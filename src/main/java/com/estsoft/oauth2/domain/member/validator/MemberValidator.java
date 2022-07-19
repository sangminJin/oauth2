package com.estsoft.oauth2.domain.member.validator;

import com.estsoft.oauth2.domain.member.entity.Member;
import com.estsoft.oauth2.domain.member.repository.MemberRepository;
import com.estsoft.oauth2.global.config.error.exception.BusinessException;
import com.estsoft.oauth2.global.config.error.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberValidator {

    private final MemberRepository memberRepository;

    public void validateDuplicateMember(String email){
        Optional<Member> optionalMember = memberRepository.findByEmail(email);
        if(optionalMember.isPresent()){
            throw new BusinessException(ErrorCode.ALREADY_REGISTERED_MEMBER);
        }
    }

}