package com.example.shoppingmall.member.repository;

import com.example.shoppingmall.member.domain.Member;
import com.example.shoppingmall.member.dto.MemberPwDTO;
import com.example.shoppingmall.member.dto.MemberSearchDTO;
import com.example.shoppingmall.member.form.MemberSearchForm;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface MemberRepository {
    void save(Member member);
    void update(Member member);
    void deleteByNo(Long memberNo);
    Optional<Member> findByNo(Long memberNo);
    Optional<Member> findById(String memberId);
    Optional<Member> findByEmail(String memberEmail);
    Optional<Member> findByHp(String memberHp);
    List<Member> findAllByPaging(Map<String, Integer> pagingSettings);
    int countById(String memberId);
    int countByEmail(String memberEmail);
    int countByHp(String memberHp);

    Long countAll();
    Long countAllByKeyword(MemberSearchForm memberSearchForm);
    List<Member> findAllByKeyword(MemberSearchForm memberSearchForm);

    void updatePwFindById(MemberPwDTO memberPwDTO);
}
