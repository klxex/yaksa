package com.hwan.yaksa.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

//연습용 간단 세션
@Entity
@Getter
@Setter
public class Session {
    @Id
    @GeneratedValue
    @Column(name="session_id")
    private Long id;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="member_id")
    private Member member;
}
