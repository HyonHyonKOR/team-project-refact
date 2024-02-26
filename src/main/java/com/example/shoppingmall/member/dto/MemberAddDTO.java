package com.example.shoppingmall.member.dto;

import com.example.shoppingmall.member.domain.Member;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import static com.example.shoppingmall.member.validation.MemberValidationGroup.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberAddDTO {

    @NotBlank(message = "会員IDをご入力ください。.", groups = MemberNotBlankGroup.class)
    @Pattern(regexp = "[a-z0-9]{5,20}", message = "正しくない会員IDの形式です。", groups = MemberPatternGroup.class)
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
    @NotBlank(message = "メールアドレスをご入力ください。.", groups = MemberNotBlankGroup.class)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,50}$", message = "正しくないメールアドレスです。", groups = MemberPatternGroup.class)
    private String memberEmail;
    @NotNull(message = "郵便番号をご入力ください。.", groups = MemberNotBlankGroup.class)
    private Integer memberPostalCode;
    @NotBlank(message = "基本住所をご入力ください。." ,groups = MemberNotBlankGroup.class)
    private String memberAddressBasic;
    @Pattern(regexp = "[\\s가-힣a-zA-Z0-9]{0,50}", message = "最大50字まで入力可能です。", groups = MemberPatternGroup.class)
    private String memberAddressDetail;

    public static Member MemberAddDTOToMember(MemberAddDTO memberAddDTO) {
        Member member = new Member();
        member.setMemberId(memberAddDTO.getMemberId());
        member.setMemberHp(memberAddDTO.getMemberHp());
        member.setMemberEmail(memberAddDTO.getMemberEmail());
        member.setMemberPw(memberAddDTO.getMemberPw());
        member.setMemberName(memberAddDTO.getMemberName());
        member.setMemberPostalCode(memberAddDTO.getMemberPostalCode());
        member.setMemberAddressBasic(memberAddDTO.getMemberAddressBasic());
        member.setMemberAddressDetail(memberAddDTO.getMemberAddressDetail());
        return member;
    }

}
