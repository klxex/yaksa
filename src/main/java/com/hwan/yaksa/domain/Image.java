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
public class Image {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="image_id")
    public Long id;
    public String dir;
    public String name;

    @OneToOne(mappedBy="image")
    public Item item;

    @Builder
    public Image(String dir,String name){
        this.dir=dir;
        this.name=name;
    }
}
