package com.example.solprofileapi.service;

import com.example.solprofileapi.dto.request.MemberCreateRequestDto;
import com.example.solprofileapi.dto.response.MemberCreateResponseDto;
import com.example.solprofileapi.dto.response.MemberReadResponseDto;
import com.example.solprofileapi.entity.Member;
import com.example.solprofileapi.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
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
}
