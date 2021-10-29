package com.hwan.yaksa.formLogin;

import com.hwan.yaksa.domain.user.Account;
import com.hwan.yaksa.domain.user.Role;
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
    private Role role;

    @Builder
    public LoginDto(String name, String email, String password, String picture,Role role) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.picture = picture;
        this.role=role;
    }



    public Account toEntity(){
        return Account.builder()
                .name(name)
                .email(email)
                .picture(picture)
                .password(password)
                .role(role)
                .build();
    }

}
