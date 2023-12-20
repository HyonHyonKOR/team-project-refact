package com.example.shoppingmall.cart.repository;

import com.example.shoppingmall.cart.domain.Cart;
import com.example.shoppingmall.cart.mapper.CartMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
@RequiredArgsConstructor
public class MyBatisCartRepository implements CartRepository{

    private final CartMapper cartMapper;

    @Override
    public ArrayList<Cart> getCartList(Long memberNo) {
        return cartMapper.getCartList(memberNo);
    }

    @Override
    public String getItemThumbnails(Long itemNo) {
        return cartMapper.getItemThumbnails(itemNo);
    }

    @Override
    public String getItemName(Long itemNo) {

        return cartMapper.getItemName(itemNo);

    }
    @Override
    public Integer getItemPrice(Long itemNo){
        return cartMapper.getItemPrice(itemNo);
    }

    @Override
    public void updateCartItem(Long cartNo, Integer updateQuantity){
        cartMapper.updateCartItem(cartNo, updateQuantity);
    }

    public void deleteCartItem(Long cartNo){
        cartMapper.deleteCartItem(cartNo);
    }
}
