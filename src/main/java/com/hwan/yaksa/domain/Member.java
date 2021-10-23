package com.hwan.yaksa.domain;


import com.hwan.yaksa.enumerate.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.LinkedList;
import java.util.List;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @Column(name = "member_id")
    private String id;
    private String password;
    private String name;
    private int age;
    @OneToMany(mappedBy = "member")
    private List<Session> sessions=new LinkedList<>();

    @Enumerated(value=EnumType.STRING)
    private Role role;
    public LocalDateTime createDateTime;




}
