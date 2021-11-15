package com.hwan.yaksa.cart;


import com.hwan.yaksa.authLogin.dto.SessionUser;
import com.hwan.yaksa.item.ItemDto;

public interface CartService {
    public void addCartItem(SessionUser sessionUser, ItemDto itemDto);
    public CartResponseDto getCart(SessionUser sessionUser);


}
