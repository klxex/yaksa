package com.hwan.yaksa.service;

import com.hwan.yaksa.domain.user.Account;
import com.hwan.yaksa.domain.user.AccountContext;
import com.hwan.yaksa.dto.LoginDto;
import com.hwan.yaksa.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
}
