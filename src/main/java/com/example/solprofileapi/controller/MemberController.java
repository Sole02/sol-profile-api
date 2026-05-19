package com.example.solprofileapi.controller;

import com.example.solprofileapi.dto.request.MemberCreateRequestDto;
import com.example.solprofileapi.dto.response.MemberCreateResponseDto;
import com.example.solprofileapi.dto.response.MemberReadResponseDto;
import com.example.solprofileapi.service.MemberService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
}
