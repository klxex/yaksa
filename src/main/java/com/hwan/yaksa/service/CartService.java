package com.hwan.yaksa.service;


import com.hwan.yaksa.authLogin.dto.SessionUser;
import com.hwan.yaksa.dto.CartResponseDto;
import com.hwan.yaksa.dto.ItemDto;

public interface CartService {
    public void addCartItem(SessionUser sessionUser, ItemDto itemDto,int quantity);
    public CartResponseDto getCart(SessionUser sessionUser);


}
