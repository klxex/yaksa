package com.hwan.yaksa.repository;

import com.hwan.yaksa.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {

}
