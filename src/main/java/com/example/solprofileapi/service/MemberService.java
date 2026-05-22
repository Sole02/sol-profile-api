package com.example.solprofileapi.service;

import com.example.solprofileapi.dto.request.MemberCreateRequestDto;
import com.example.solprofileapi.dto.response.MemberCreateResponseDto;
import com.example.solprofileapi.dto.response.MemberReadResponseDto;
import com.example.solprofileapi.entity.Member;
import com.example.solprofileapi.repository.MemberRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.presigner.S3Presigner;
import software.amazon.awssdk.services.s3.presigner.model.GetObjectPresignRequest;

import java.io.IOException;
import java.time.Duration;

@Service
@Slf4j
public class MemberService {

    private final MemberRepository memberRepository;
    private final S3Client s3Client;
    private final S3Presigner s3Presigner;

    @Value("${S3_BUCKET_NAME}")
    private String bucketName;

    public MemberService(MemberRepository memberRepository, S3Client s3Client, S3Presigner s3Presigner) {
        this.memberRepository = memberRepository;
        this.s3Client = s3Client;
        this.s3Presigner = s3Presigner;
    }


    // 프로필 등록
    @Transactional
    public MemberCreateResponseDto createMember(MemberCreateRequestDto request) {
        Member member = new Member(request.getName(), request.getAge(), request.getMbti());
        Member savedMember = memberRepository.save(member);
        MemberCreateResponseDto response = new MemberCreateResponseDto(savedMember.getId(), savedMember.getName(), savedMember.getAge(), savedMember.getMbti());
        return response;
    }

    // 정보 조회
    @Transactional(readOnly = true)
    public MemberReadResponseDto readMember(Long memberId) {
        Member foundMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 멤버입니다."));
        MemberReadResponseDto response = new MemberReadResponseDto(foundMember.getId(), foundMember.getName(), foundMember.getAge(), foundMember.getMbti());
        return response;
    }

    // 프로필 사진 업로드
    @Transactional
    public String uploadProfileImage(Long memberId, MultipartFile image) {
        Member foundMember = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 멤버입니다."));

        try {
            String fileName = memberId + "_" + image.getOriginalFilename();
            PutObjectRequest putObjectRequest = PutObjectRequest.builder()
                    .bucket(bucketName)
                    .key(fileName)
                    .contentType(image.getContentType())
                    .build();

            s3Client.putObject(putObjectRequest,
                    RequestBody.fromBytes(image.getBytes()));

            String imageUrl = "https://" + bucketName + ".s3.ap-northeast-2.amazonaws.com/" + fileName;
            foundMember.updateProfileImageUrl(imageUrl);
            return imageUrl;
        } catch (IOException e) {
            log.error("[API - ERROR] 이미지 업로드 실패", e);
            throw new IllegalStateException("이미지 업로드에 실패했습니다.");
        }
    }

    // Presigned URL 생성
    @Transactional(readOnly = true)
    public String readProfileUrl(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalStateException("존재하지 않는 멤버입니다."));

        String fileName = member.getProfileImageUrl()
                .replace("https://" + bucketName + ".s3.ap-northeast-2.amazonaws.com/", "");

        GetObjectRequest getObjectRequest = GetObjectRequest.builder()
                .bucket(bucketName)
                .key(fileName)
                .build();

        GetObjectPresignRequest presignRequest = GetObjectPresignRequest.builder()
                .signatureDuration(Duration.ofDays(7))
                .getObjectRequest(getObjectRequest)
                .build();

        return s3Presigner.presignGetObject(presignRequest).url().toString();
    }
}
