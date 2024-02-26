package com.example.shoppingmall.order.dto;

import com.example.shoppingmall.order.domain.MemberOrder;
import com.example.shoppingmall.order.domain.MemberOrderDetail;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.util.List;

import static com.example.shoppingmall.order.validation.OrderValidationGroup.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MemberOrderAddDTO {

    private Long memberOrderNo;
    private Long memberNo;
    private Timestamp orderTime;
    @NotBlank(message = "携帯番号をご入力ください。.", groups = OrderNotBlankGroup.class)
    @Pattern(regexp = "^01(?:0|1|[6-9])\\d{7,8}$", message = "正しくない携帯番号の形式です。", groups = OrderPatternGroup.class)
    private String orderHp;
    @NotNull(message = "郵便番号をご入力ください。.", groups = OrderNotBlankGroup.class)
    private Integer orderPostalCode;
    @NotBlank(message = "기본주소를 ご入力ください。.", groups = OrderNotBlankGroup.class)
    private String orderAddressBasic;
    @Pattern(regexp = "[\\s가-힣a-zA-Z0-9]{0,50}", message = "最大50字まで入力可能です。", groups = OrderPatternGroup.class)
    private String orderAddressDetail;
    @NotBlank(message = "お名前をご入力ください。.", groups = OrderNotBlankGroup.class)
    @Pattern(regexp = "[가-힣]{2,40}", message = "正しくない名前の形式です。", groups = OrderPatternGroup.class)
    private String receiverName;
    private Integer orderStatus;

    private List<MemberOrderDetailDTO> memberOrderDetailDTOList;
    private List<MemberOrderDetailAddDTO> memberOrderDetailAddDTOList;

    public static MemberOrder toMemberOrder(Long memberNo, MemberOrderAddDTO memberOrderAddDTO) {
        MemberOrder memberOrder = new MemberOrder();
        memberOrder.setMemberOrderNo(memberOrderAddDTO.getMemberOrderNo());
        memberOrder.setMemberNo(memberNo);
        memberOrder.setOrderTime(memberOrderAddDTO.getOrderTime());
        memberOrder.setOrderHp(memberOrderAddDTO.getOrderHp());
        memberOrder.setOrderPostalCode(memberOrderAddDTO.getOrderPostalCode());
        memberOrder.setOrderAddressBasic(memberOrderAddDTO.getOrderAddressBasic());
        memberOrder.setOrderAddressDetail(memberOrderAddDTO.getOrderAddressDetail());
        memberOrder.setReceiverName(memberOrderAddDTO.getReceiverName());
        memberOrder.setOrderStatus(1);
        //memberOrder.setMemberOrderDetailDTOList(memberOrderAddDTO.getMemberOrderDetailDTOList());
        return memberOrder;
    }

}
