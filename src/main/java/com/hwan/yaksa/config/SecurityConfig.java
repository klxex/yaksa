package com.hwan.yaksa.config;
import com.hwan.yaksa.authLogin.CustomOAuth2UserService;
import com.hwan.yaksa.formLogin.FormAuthenticationProvider;
import com.hwan.yaksa.domain.user.Role;
import com.hwan.yaksa.formLogin.CustomUserDetailsService;
import com.hwan.yaksa.formLogin.FormSuccessHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final CustomOAuth2UserService customOAuth2UserService;
    private final CustomUserDetailsService customUserDetailsService;
    private final FormAuthenticationProvider formAuthenticationProvider;
    private final FormSuccessHandler formSuccessHandler;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/","/signup", "/css/**", "/images/**", "/js/**", "/h2-console/**", "/profile").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.USER.name())
                .anyRequest().authenticated()
                .and()
                .logout()
                .logoutSuccessUrl("/")
                .and()
                .formLogin()
                .loginPage("/")
                .loginProcessingUrl("/loginProcess")
                .permitAll()
                .successHandler(formSuccessHandler)
                .and()
                .authenticationProvider(formAuthenticationProvider)
                .oauth2Login()
                .userInfoEndpoint()
                .userService(customOAuth2UserService);
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception { // 9
        auth.userDetailsService(customUserDetailsService)
                // 해당 서비스(userService)에서는 UserDetailsService를 implements해서
                // loadUserByUsername() 구현해야함 (서비스 참고)
                .passwordEncoder(new BCryptPasswordEncoder());
    }

}
