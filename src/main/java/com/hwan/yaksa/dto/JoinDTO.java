package com.hwan.yaksa.dto;

import com.hwan.yaksa.enumerate.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;


@Getter
@Setter
public class JoinDTO {

    @NotNull
    private String login_id;
    @NotNull
    private String password;
    private String name;
    private int age;

    @Enumerated(EnumType.STRING)
    private Role role;



}
