package com.hwan.yaksa.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;

@Entity
@Getter
@Setter
public class Delivery {
    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(mappedBy="delivery",fetch= LAZY)
    private Order order;

    @OneToOne
    @JoinColumn(name="address_id")
    private Address address;

    private String companyName;

    @Enumerated(EnumType.STRING)
    private DeliveryStatus status; //READY , COMP

}
