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
public class Address {
    @Id
    @GeneratedValue
    @Column(name="address_id")
    private Long id;
    private String city;
    private String street;
    private String zipcode;

    @OneToOne(mappedBy="address")
    private Delivery delivery;


    @Builder
    public Address(String city,String street,String zipcode){
        this.city=city;
        this.street=street;
        this.zipcode=zipcode;
    }
}
