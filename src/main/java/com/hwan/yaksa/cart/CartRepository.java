package com.hwan.yaksa.cart;

import com.hwan.yaksa.domain.Cart;
import com.hwan.yaksa.domain.user.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart,Long> {

    public Optional<Cart> findByAccount(Account account);
}
