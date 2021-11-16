package com.hwan.yaksa.service;

import com.hwan.yaksa.dto.OrderDto;
import com.hwan.yaksa.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;


    @Override
    public void createOrder() {

    }

    @Override
    public OrderDto searchOrder() {
        return null;
    }
}
