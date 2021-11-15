package com.hwan.yaksa.authLogin.dto;


import com.hwan.yaksa.domain.user.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter @Setter
@NoArgsConstructor
public class SessionUser implements Serializable {
    private String name;
    private String email;
    private String picture;

    public SessionUser(Account account) {
        this.name = account.getName();
        this.email = account.getEmail();
        this.picture = account.getPicture();
    }
}
