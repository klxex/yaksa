package com.hwan.yaksa.domain.user;

import com.hwan.yaksa.domain.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Account extends TimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
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

//    @Column
//    private Address address;

    @OneToOne(mappedBy = "account",cascade = CascadeType.ALL)
    private Cart cart;

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Board> boards = new ArrayList<>();

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL)
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Account(String name, String email, String password, String picture, Role role) {
        this.name = name;
        this.email = email;
        this.picture = picture;
        this.password = password;
        this.role = role;
    }

    public String getRoleKey() {
        return this.role.getKey();
    }


    public Account update(String name, String picture) {
        this.name = name;
        this.picture = picture;
        return this;
    }

    public void createBoard(Board board) {
        boards.add(board);
        board.setAccount(this);
    }

    public void addCart(Cart cart){
        this.setCart(cart);
        cart.setAccount(this);
    }




}
