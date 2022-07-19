package com.estsoft.oauth2;

import com.estsoft.oauth2.api.login.dto.MemberRegisterDto;
import com.estsoft.oauth2.api.login.service.SignUpService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Slf4j
public class CommandRunner implements CommandLineRunner {

    private final SignUpService signUpService;


    @Override
    public void run(String... args) {
        initData();
    }

    @Transactional
    public void initData() {
        MemberRegisterDto memberRegisterDto = MemberRegisterDto.builder()
                .name("진상민")
                .email("jin0849@estsoft.com")
                .password("1q2w3e4r")
                .password2("1q2w3e4r")
                .build();

        signUpService.registerUser(memberRegisterDto);
    }

}
