package com.hwan.yaksa.domain;


import com.hwan.yaksa.domain.user.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class CartItem {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;

    @ManyToOne
    @JoinColumn(name="item_id")
    private Item item;

    private int count;

    public static CartItem createCartItem(Item item,int count){
        CartItem cartItem = new CartItem();
        cartItem.setItem(item);
        cartItem.setCount(count);
        item.getCartItems().add(cartItem);

        return cartItem;
    }


}
