package com.apptive.marico.controller.auth;

import com.apptive.marico.dto.LoginDto;
import com.apptive.marico.dto.member.MemberRequestDto;
import com.apptive.marico.dto.member.MemberResponseDto;
import com.apptive.marico.dto.stylist.StylistRequestDto;
import com.apptive.marico.dto.stylist.StylistResponseDto;
import com.apptive.marico.dto.token.TokenRequestDto;
import com.apptive.marico.dto.token.TokenResponseDto;
import com.apptive.marico.service.CustomUserDetailsService;
import com.apptive.marico.service.StylistAuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth/stylist")
@RequiredArgsConstructor
public class StylistAuthController {
    private final StylistAuthService stylistAuthService;

    @PostMapping("/signup")
    public ResponseEntity<StylistResponseDto> signup(@RequestBody StylistRequestDto stylistRequestDto) {
        return ResponseEntity.ok(stylistAuthService.signup(stylistRequestDto));
    }
}
