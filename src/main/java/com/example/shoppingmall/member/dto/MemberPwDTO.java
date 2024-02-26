package com.example.shoppingmall.member.dto;

import com.example.shoppingmall.member.domain.Member;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import static com.example.shoppingmall.member.validation.MemberValidationGroup.*;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberPwDTO {
    @NotBlank(message = "会員IDをご入力ください。", groups = MemberNotBlankGroup.class)
    private String memberId;
    @NotBlank(message = "メールアドレスをご入力ください。", groups = MemberNotBlankGroup.class)
    private String memberEmail;
    @NotBlank(message = "携帯番号をご入力ください。", groups = MemberNotBlankGroup.class)
    private String memberHp;
//    @NotBlank(message = "비밀번호를 ご入力ください。", groups = MemberNotBlankGroup.class)
    private String memberPw;

    public static MemberPwDTO MemberToMemberPwDTO(Member member){
        MemberPwDTO memberPwDTO = new MemberPwDTO();
        memberPwDTO.setMemberId(member.getMemberId());
        memberPwDTO.setMemberEmail(member.getMemberEmail());
        memberPwDTO.setMemberHp(member.getMemberHp());
        memberPwDTO.setMemberPw(member.getMemberPw());
        return memberPwDTO;
    }
    public static Member MemberPwDTOToMember(MemberPwDTO memberPwDTO){
        Member member = new Member();
        member.setMemberId(memberPwDTO.getMemberId());
        member.setMemberEmail(memberPwDTO.getMemberEmail());
        member.setMemberHp(memberPwDTO.getMemberHp());
        return member;

    }

}
