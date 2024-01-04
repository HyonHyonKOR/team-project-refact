package com.example.shoppingmall.order.mapper;

import com.example.shoppingmall.order.domain.MemberOrder;
import com.example.shoppingmall.order.domain.MemberOrderDetail;
import com.example.shoppingmall.order.form.MemberOrderViewForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.HashMap;
import java.util.List;

@Mapper
public interface MemberOrderMapper {

    /* user */
    void saveMemberOrder(MemberOrder memberOrder);

    /* user */
    Long getMaxMemberOrderNo();

    /* user */
    void saveMemberOrderDetail(MemberOrderDetail memberOrderDetail);

    /* user */
    List<MemberOrder> findMemberOrderList(MemberOrderViewForm memberOrderViewForm);

    /* user */
    MemberOrderDetail findMemberOrderDetail(Long memberOrderNo);

    /* admin */
    List<MemberOrder> getMemberOrderList();

    MemberOrderDetail getMemberOrderDetail();

    MemberOrder joinMemeberOrderByMemberOrderNo(Long orderNo);


    MemberOrder findMemberOrderByNo(Long memberOrderNo);

    List<MemberOrder> findAllMemberOrdersByNo(Long memberNo);
}
