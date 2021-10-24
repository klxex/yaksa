package com.hwan.yaksa.dto;

import com.hwan.yaksa.domain.user.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LoginDto {
    private String name;
    private String email;
    private String password;
    private String picture;

    @Builder
    public LoginDto(String name, String email, String password, String picture) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.picture = picture;
    }



    public Account toEntity(){
       return Account.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .password(password)
                .build();
    }




}
