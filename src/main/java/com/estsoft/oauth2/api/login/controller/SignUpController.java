package com.estsoft.oauth2.api.login.controller;

import com.estsoft.oauth2.api.login.dto.MemberRegisterDto;
import com.estsoft.oauth2.api.login.service.SignUpService;
import com.estsoft.oauth2.global.config.error.exception.BusinessException;
import com.estsoft.oauth2.global.config.error.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("/members")
public class SignUpController {

    private final SignUpService signUpService;

    @PostMapping
    public void signUp(@Valid @RequestBody MemberRegisterDto memberRegisterDto) {
        if(!Objects.equals(memberRegisterDto.getPassword(), memberRegisterDto.getPassword2())) {
            throw new BusinessException(ErrorCode.PASSWORD_MISMATCHED);
        }

        signUpService.registerUser(memberRegisterDto);
    }

}