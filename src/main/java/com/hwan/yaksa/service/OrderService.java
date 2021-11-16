package com.hwan.yaksa.service;

import com.hwan.yaksa.dto.OrderDto;

public interface OrderService {

    public void createOrder();

    public OrderDto searchOrder();
}
