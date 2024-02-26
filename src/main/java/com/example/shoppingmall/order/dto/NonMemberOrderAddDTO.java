package com.example.shoppingmall.order.dto;

import com.example.shoppingmall.member.validation.MemberValidationGroup;
import com.example.shoppingmall.order.domain.NonMemberOrder;
import com.example.shoppingmall.order.validation.OrderValidationGroup;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

import static com.example.shoppingmall.order.validation.OrderValidationGroup.*;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NonMemberOrderAddDTO {

    @NotBlank(message = "お名前をご入力ください。.", groups = OrderNotBlankGroup.class)
    private String nonMemberName;
    @NotBlank(message = "携帯番号をご入力ください。.", groups = OrderNotBlankGroup.class)
    @Pattern(regexp = "^01(?:0|1|[6-9])\\d{7,8}$", message = "正しくない携帯番号の形式です。", groups = OrderPatternGroup.class)
    private String orderHp;
    @NotBlank(message = "メールアドレスをご入力ください。.", groups = OrderNotBlankGroup.class)
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,50}$", message = "正しくないメールアドレスの形式です。", groups = OrderPatternGroup.class)
    private String orderEmail;
    @NotBlank(message = "お名前をご入力ください。.", groups = OrderNotBlankGroup.class)
    private String receiverName;
    @NotNull(message = "郵便番号をご入力ください。.", groups = OrderNotBlankGroup.class)
    private Integer orderPostalCode;
    @NotBlank(message = "基本住所を入力ください。.", groups = OrderNotBlankGroup.class)
    private String orderAddressBasic;
    @Pattern(regexp = "[\\s가-힣a-zA-Z0-9]{0,50}", message = "最大50字まで可能です。", groups = OrderPatternGroup.class)
    private String orderAddressDetail;

    public static NonMemberOrder toNonMemberOrder(NonMemberOrderAddDTO nonMemberOrderAddDTO){
        NonMemberOrder nonMemberOrder = new NonMemberOrder();
        nonMemberOrder.setNonMemberOrderNo(null);
        nonMemberOrder.setOrderTime(null);
        nonMemberOrder.setOrderStatus(null);
        nonMemberOrder.setNonMemberName(nonMemberOrderAddDTO.getNonMemberName());
        nonMemberOrder.setOrderHp(nonMemberOrderAddDTO.getOrderHp());
        nonMemberOrder.setOrderEmail(nonMemberOrderAddDTO.getOrderEmail());
        nonMemberOrder.setReceiverName(nonMemberOrderAddDTO.getReceiverName());
        nonMemberOrder.setOrderPostalCode(nonMemberOrderAddDTO.getOrderPostalCode());
        nonMemberOrder.setOrderAddressBasic(nonMemberOrderAddDTO.getOrderAddressBasic());
        nonMemberOrder.setOrderAddressDetail(nonMemberOrderAddDTO.getOrderAddressDetail());
        return nonMemberOrder;
    }

}