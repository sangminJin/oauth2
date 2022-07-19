package com.estsoft.oauth2.domain.member.service;

import com.estsoft.oauth2.domain.member.validator.MemberValidator;
import com.estsoft.oauth2.domain.member.entity.Member;
import com.estsoft.oauth2.domain.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional(readOnly = true)
@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final MemberValidator memberValidator;

    @Transactional
    public void saveMember(Member member) {
        memberValidator.validateDuplicateMember(member.getEmail());
        memberRepository.save(member);
    }
}
