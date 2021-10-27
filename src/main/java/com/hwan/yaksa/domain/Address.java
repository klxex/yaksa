package com.hwan.yaksa.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String city;
    private String street;
    private String zipcode;

    public Address(String city,String street,String zipcode){
        this.city=city;
        this.street=street;
        this.zipcode=zipcode;
    }
}
