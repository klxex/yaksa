package com.hwan.yaksa.repository;

import com.hwan.yaksa.domain.user.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account,Long> {
    Optional<Account> findByEmail(String email);
}
