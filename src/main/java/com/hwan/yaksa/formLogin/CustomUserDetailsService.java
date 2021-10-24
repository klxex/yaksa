package com.hwan.yaksa.formLogin;

import com.hwan.yaksa.domain.user.Account;
import com.hwan.yaksa.formLogin.AccountContext;
import com.hwan.yaksa.dto.LoginDto;
import com.hwan.yaksa.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService{
    private final AccountRepository accountRepository;


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("username 이 존재하지 않습니다: " + email));
        return new AccountContext(account);
    }

    public Long save(LoginDto loginDto){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        loginDto.setPassword(encoder.encode(loginDto.getPassword()));

        return accountRepository.save(loginDto.toEntity())
                .getId();
    }
}
