package com.hwan.yaksa.dto;

import com.hwan.yaksa.domain.CartItem;
import com.hwan.yaksa.domain.user.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class CartResponseDto {
    private Long id;
    private List<CartItem> cartItems = new ArrayList<>();
    private Account account;

    @Builder
    public CartResponseDto(Long id,Account account) {
        this.id = id;
        this.cartItems = cartItems;
        this.account = account;
    }

}
