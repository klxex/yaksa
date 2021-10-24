package com.hwan.yaksa.domain.user;

import com.hwan.yaksa.domain.TimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Account extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String email;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Column
    private String picture;


    @Builder
    public Account(String name, String email, String password, String picture, Role role){
        this.name=name;
        this.email=email;
        this.picture=picture;
        this.password=password;
        this.role=role;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }


    public Account update(String name, String picture) {
        this.name = name;
        this.picture=picture;
        return this;
    }





}
