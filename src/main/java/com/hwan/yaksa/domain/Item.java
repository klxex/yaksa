package com.hwan.yaksa.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Item extends TimeEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    private int count;
    private int price;
    @OneToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="image_id")
    private Image image;

    @Builder
    public Item(String name, String description, int count, int price, Image image) {
        this.name = name;
        this.description = description;
        this.count = count;
        this.price = price;
        this.image = image;
    }






}
