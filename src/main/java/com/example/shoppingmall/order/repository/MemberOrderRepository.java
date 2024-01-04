package com.example.shoppingmall.order.repository;

import com.example.shoppingmall.order.domain.MemberOrder;
import com.example.shoppingmall.order.domain.MemberOrderDetail;
import com.example.shoppingmall.order.form.MemberOrderViewForm;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public interface MemberOrderRepository {

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

    List<MemberOrder> getMemberOrderList();

    MemberOrderDetail getMemberOrderDetail();


    MemberOrder findMemberOrderByNo(Long memberOrderNo);

    List<MemberOrder> findAllMemberOrdersByNo(Long memberNo);
}
