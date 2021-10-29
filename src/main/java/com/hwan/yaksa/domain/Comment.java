package com.hwan.yaksa.domain;

import com.hwan.yaksa.domain.user.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;

    @ManyToOne
    @JoinColumn(name="board_id")
    private Board board;

    private String content;

    @Builder
    public Comment(Long id, Account account, Board board, String content) {
        this.id = id;
        this.account = account;
        this.board = board;
        this.content = content;
    }





}
