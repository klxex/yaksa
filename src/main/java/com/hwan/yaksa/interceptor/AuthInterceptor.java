package com.hwan.yaksa.interceptor;

import com.hwan.yaksa.annotation.Auth;
import com.hwan.yaksa.config.auth.dto.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final MemberRepository memberRepository;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        HandlerMethod handlerMethod = (HandlerMethod) handler;

        Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
        if (auth == null) {
            return true;
        }

        Long sessionId = (Long) request.getSession().getAttribute("sessionId");
        SessionUser googleId = (SessionUser) request.getSession().getAttribute("user");

        if (sessionId == null && googleId==null) {
            response.sendRedirect("/");
            return false;
        }
        else {
//            if (memberRepository.findSession(sessionId) == null) {
//                response.sendRedirect("/");
//                return false;
//            } else {
//                return true;
//            }
            return true;
        }


    }
}
