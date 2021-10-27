package com.hwan.yaksa.domain;


import com.hwan.yaksa.domain.user.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Board extends TimeEntity {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false,length=100)
    private String title;

    @Lob
    private String boardContent;

    @ColumnDefault("0")
    private int readCount=0;


    private String writer;

    @ManyToOne
    @JoinColumn(name="account_id")
    private Account account;

    @Builder
    public Board(String title,String writer,String boardContent,int readCount){
        this.title=title;
        this.writer=writer;
        this.boardContent=boardContent;
        this.readCount=readCount;
    }
}
