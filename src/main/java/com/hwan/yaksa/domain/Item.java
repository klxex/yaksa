package com.hwan.yaksa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Item extends TimeEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String name;

    private String description;

    private int count;

    private int price;

    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="image_id")
    private Image image;

    @OneToMany(mappedBy="item")
    private List<CartItem> cartItems = new ArrayList<>();

    @OneToMany(mappedBy = "item")
    private List<OrderItem> orderItems =new ArrayList<>();

    @Builder
    public Item(String name, String description, int count, int price, Image image) {
        this.name = name;
        this.description = description;
        this.count = count;
        this.price = price;
        this.image = image;
    }


    public void addStock(int quantity){
        count += quantity;
    }

    public void removeStock(int quantity){
        int restStock = this.count - quantity;
        count = restStock;
    }










}
