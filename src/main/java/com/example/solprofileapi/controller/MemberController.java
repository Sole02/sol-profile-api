package com.example.solprofileapi.controller;

import com.example.solprofileapi.dto.request.MemberCreateRequestDto;
import com.example.solprofileapi.dto.response.MemberCreateResponseDto;
import com.example.solprofileapi.dto.response.MemberReadResponseDto;
import com.example.solprofileapi.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/members")
@Slf4j
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }


    // 프로필 등록
    @PostMapping
    public ResponseEntity<MemberCreateResponseDto> createMember(@RequestBody MemberCreateRequestDto request) {
        log.info("[API - LOG] POST");
        MemberCreateResponseDto createResponseDto = memberService.createMember(request);
        ResponseEntity<MemberCreateResponseDto> createResponse = new ResponseEntity<>(createResponseDto, HttpStatus.CREATED);
        return createResponse;
    }

    // 정보 조회
    @GetMapping("/{memberId}")
    public ResponseEntity<MemberReadResponseDto> readMember(@PathVariable Long memberId) {
        log.info("[API - LOG] GET", memberId);
        MemberReadResponseDto readResponseDto = memberService.readMember(memberId);
        ResponseEntity<MemberReadResponseDto> readResponse = new ResponseEntity<>(readResponseDto, HttpStatus.OK);
        return readResponse;
    }

    // 예외 처리
    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<String> handleException(IllegalStateException e) {
        log.error("[API - ERROR] {}", e.getMessage(), e);
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    // 프로필 사진 업로드
    @PostMapping("/{memberId}/profile-image")
    public ResponseEntity<String> uploadProfileImage(@PathVariable Long memberId, @RequestParam("image") MultipartFile image) {
        log.info("[API - LOG] POST", memberId);
        String imageUrl = memberService.uploadProfileImage(memberId, image);
        ResponseEntity<String> uploadResponse = new ResponseEntity<>(imageUrl, HttpStatus.CREATED);
        return uploadResponse;
    }

    // 프로필 사진 조회
    @GetMapping("/{memberId}/profile-image")
    public ResponseEntity<String> readProfileImage(@PathVariable Long memberId) {
        log.info("[API - LOG] GET", memberId);
        String readUrl = memberService.readProfileUrl(memberId);
        ResponseEntity<String> getResponse = new ResponseEntity<>(readUrl, HttpStatus.OK);
        return getResponse;
    }
}
