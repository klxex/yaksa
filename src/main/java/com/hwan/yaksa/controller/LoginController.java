package com.hwan.yaksa.controller;


import com.hwan.yaksa.dto.LoginDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class LoginController{
    private final UserService userService;

    @GetMapping("/")
    public String home(Model model){
        model.addAttribute("loginDto",new LoginDto());
        return "index";
    }


    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("loginDto",new LoginDto());
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(LoginDto loginDto){
        userService.save(loginDto);
        return "redirect:/";
    }
}
