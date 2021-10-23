package com.hwan.yaksa.controller;

import com.hwan.yaksa.annotation.Auth;
import com.hwan.yaksa.config.auth.LoginUser;
import com.hwan.yaksa.config.auth.dto.SessionUser;
import com.hwan.yaksa.domain.Member;
import com.hwan.yaksa.dto.JoinDTO;
import com.hwan.yaksa.dto.LoginDTO;
import com.hwan.yaksa.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/")
    public String getLoginPage(Model model,@LoginUser SessionUser user){
        model.addAttribute("loginDTO", new LoginDTO());

        if(user!=null){
            model.addAttribute("userName",user.getName());
        }

        return "login/index";
    }

    @GetMapping("/join")
    public String getJoinPage(Model model){
        model.addAttribute("joinDTO", new JoinDTO());
        return "login/join";
    }

    @GetMapping("/myPage")
    public String myPage(Model model){
        return "login/myPage";
    }

    @GetMapping("/main")
    @Auth
    public String getMainPage(Model model){
        return "login/main";
    }

    @PostMapping("/createJoin")
    public String createJoin(@ModelAttribute("joinDTO") @Valid JoinDTO joinDTO, Model model){
        memberService.createMember(joinDTO);
        return "redirect:/";
    }

    @PostMapping("/tryLogin")
    public String tryLogin(HttpSession httpSession, @ModelAttribute("loginDTO") @Valid LoginDTO loginDTO, Model model){

        int flag = memberService.checkLogin(loginDTO);
        if(flag==0){
          Long sessionId=memberService.createSession(loginDTO);
          httpSession.setAttribute("sessionId",sessionId);

          return "redirect:/main";
        }
        else{
            return "redirect:/";
        }
    }
}
