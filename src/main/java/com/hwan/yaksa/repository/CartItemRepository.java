package com.hwan.yaksa.repository;

import com.hwan.yaksa.domain.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem,Long> {
}
