package com.hwan.yaksa.controller;

import com.hwan.yaksa.authLogin.LoginUser;
import com.hwan.yaksa.authLogin.dto.SessionUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartRestController {

    @PostMapping("/carts")
    public void createCart(@LoginUser SessionUser sessionUser){

    }
}
