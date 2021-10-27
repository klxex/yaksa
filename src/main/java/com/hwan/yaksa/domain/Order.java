package com.hwan.yaksa.domain;


import com.hwan.yaksa.domain.user.Account;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="orders")
public class Order extends TimeEntity {
    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;

    private int total;

    @OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name="delivery_id")
    private Delivery delivery;

    @OneToOne
    private Card card;

    @OneToMany(mappedBy="order")
    private List<OrderItem> orderItems = new ArrayList<>();

}
