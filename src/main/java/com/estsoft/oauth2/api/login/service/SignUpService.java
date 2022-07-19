package com.estsoft.oauth2.api.login.service;

import com.estsoft.oauth2.api.login.dto.MemberRegisterDto;
import com.estsoft.oauth2.domain.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class SignUpService {

    private final MemberService memberService;

    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void registerUser(MemberRegisterDto memberRegisterDto) {
        memberService.saveMember(memberRegisterDto.toEntity(passwordEncoder));
    }
}
