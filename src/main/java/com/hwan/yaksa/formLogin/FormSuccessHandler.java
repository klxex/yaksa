package com.hwan.yaksa.formLogin;

import com.hwan.yaksa.authLogin.dto.SessionUser;
import com.hwan.yaksa.domain.user.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RequiredArgsConstructor
@Component
public class FormSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        HttpSession httpSession = request.getSession();
        Account account = (Account) authentication.getPrincipal();
        httpSession.setAttribute("user",new SessionUser(account));
        response.sendRedirect("/");
    }
}
