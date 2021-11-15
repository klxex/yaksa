package com.hwan.yaksa.domain;


import com.hwan.yaksa.domain.user.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;



@Getter
@Setter
@NoArgsConstructor
@Entity
public class Cart extends TimeEntity {
    @Id
    @GeneratedValue
    @Column(name="cart_id")
    private Long id;

    @OneToMany(mappedBy="cart")
    private List<CartItem> cartItems = new ArrayList<>();

    @OneToOne
    @JoinColumn(name="account_id")
    private Account account;

    public void addCartItem(CartItem cartItem){
        cartItems.add(cartItem);
        cartItem.setCart(this);
    }

}
