package com.example.shoppingmall.member.service;

import com.example.shoppingmall.member.domain.Member;
import com.example.shoppingmall.member.dto.*;
import com.example.shoppingmall.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberInfoService {

    private final MemberRepository memberRepository;

    /*아이디 찾기*/
    @Transactional(readOnly = true)
    public MemberIdDTO getMemberIdByEmail(String memberEmail) {
        Member member = memberRepository.findByEmail(memberEmail).orElse(null);
        return  MemberIdDTO.MemberToMemberIdDTO(member);
    }
    /*비밀번호 수정 전 인증*/
    @Transactional(readOnly = true)
    public Member getMemberPw(MemberPwDTO memberPwDTO){
        Member member = MemberPwDTO.MemberPwDTOToMember(memberPwDTO);
        return memberRepository.findById(member.getMemberId())
                .filter(m -> m.getMemberEmail().equals(member.getMemberEmail()))
                .filter(m -> m.getMemberHp().equals(member.getMemberHp())).orElse(null);
    }
    /*비밀번호 변경*/
    @Transactional
    public void UpdateMemberPw(MemberPwDTO memberPwDTO){
        Member member = MemberPwDTO.MemberPwDTOToMember(memberPwDTO);
        memberRepository.update(member);
    }

    public void updatePwFindById(MemberPwDTO memberPwDTO) {
        memberRepository.updatePwFindById(memberPwDTO);
    }
}
