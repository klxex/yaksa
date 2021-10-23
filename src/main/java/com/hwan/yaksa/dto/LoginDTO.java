package com.hwan.yaksa.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
@Setter
public class LoginDTO {
    public String login_id;
    public String password;
}
