package com.example.shoppingmall.member.dto;

import com.example.shoppingmall.member.domain.Member;
import com.example.shoppingmall.member.validation.MemberValidationGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import static com.example.shoppingmall.member.validation.MemberValidationGroup.*;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberUpdateDTO {
    private Long memberNo;
    private String memberEmail;
    private String memberId;
    @NotBlank(message = "パスワードをご入力ください。.", groups = MemberNotBlankGroup.class)
    @Size( min = 8, max = 20 , groups = MemberPatternGroup.class, message="正しくないパスワードの形式です。")
    private String memberPw;
    @NotBlank(message = "パスワードをご入力ください。.", groups = MemberNotBlankGroup.class)
    @Size( min = 8, max = 20 , groups = MemberPatternGroup.class, message="正しくないパスワードの形式です。")
    private String memberPw2;
    @NotBlank(message = "携帯番号をご入力ください。.", groups = MemberNotBlankGroup.class)
    @Pattern(regexp = "^01(?:0|1|[6-9])\\d{7,8}$", message = "正しくない携帯番号の形式です。", groups = MemberPatternGroup.class)
    private String memberHp;
    @NotBlank(message = "お名前をご入力ください。.", groups = MemberNotBlankGroup.class)
    @Pattern(regexp = "[가-힣]{2,40}", message = "正しくないお名前の形式です。", groups = MemberPatternGroup.class)
    private String memberName;
    @NotNull(message = "郵便番号をご入力ください。.", groups = MemberNotBlankGroup.class)
    private Integer memberPostalCode;
    @NotBlank(message = "基本住所をご入力ください。." ,groups = MemberNotBlankGroup.class)
    private String memberAddressBasic;
    @Pattern(regexp = "[\\s가-힣a-zA-Z0-9]{0,50}", message = "最大50字まで入力可能です。", groups = MemberPatternGroup.class)
    private String memberAddressDetail;

    public static Member MemberUpdateDTOToMember(MemberUpdateDTO memberUpdateDTO){
        Member member = new Member();
        member.setMemberId(memberUpdateDTO.getMemberId());
        member.setMemberPw(memberUpdateDTO.getMemberPw());
        member.setMemberHp(memberUpdateDTO.getMemberHp());
        member.setMemberName(memberUpdateDTO.getMemberName());
        member.setMemberPostalCode(memberUpdateDTO.getMemberPostalCode());
        member.setMemberAddressBasic(memberUpdateDTO.getMemberAddressBasic());
        member.setMemberAddressDetail(memberUpdateDTO.getMemberAddressDetail());
        return member;
    }

    public static MemberUpdateDTO MemberToMemberUpdateDTO(Member member){
        MemberUpdateDTO memberUpdateDTO = new MemberUpdateDTO();
        memberUpdateDTO.setMemberId(member.getMemberId());
        memberUpdateDTO.setMemberEmail(member.getMemberEmail());
        memberUpdateDTO.setMemberHp(member.getMemberHp());
        memberUpdateDTO.setMemberName(member.getMemberName());
        memberUpdateDTO.setMemberPostalCode(member.getMemberPostalCode());
        memberUpdateDTO.setMemberAddressBasic(member.getMemberAddressBasic());
        memberUpdateDTO.setMemberAddressDetail(member.getMemberAddressDetail());
        return memberUpdateDTO;
    }


}
