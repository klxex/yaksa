package com.hwan.yaksa.controller;


import com.hwan.yaksa.authLogin.LoginUser;
import com.hwan.yaksa.authLogin.dto.SessionUser;
import com.hwan.yaksa.formLogin.LoginDto;
import com.hwan.yaksa.formLogin.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Controller
public class LoginController{
    private final CustomUserDetailsService customUserDetailsService;

    @GetMapping("/")
    public String home(Model model, @LoginUser SessionUser sessionUser){
        if(sessionUser!=null){
            model.addAttribute("loginUser",sessionUser.getName());
        }
        return "login/index";
    }


    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("loginDto",new LoginDto());
        return "login/signup";
    }

    @PostMapping("/signup")
    public String signup(LoginDto loginDto){
        customUserDetailsService.save(loginDto);
        return "redirect:/";
    }

    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "redirect:/login";
    }
}
