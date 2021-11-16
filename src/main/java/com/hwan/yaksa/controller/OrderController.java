package com.hwan.yaksa.controller;

import com.hwan.yaksa.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/order")
@Controller
public class OrderController {
    private final OrderService orderService;

    @GetMapping("/getCreateOrderForm")
    public String createOrderForm(){
        return "/order/createOrderForm";
    }

    @GetMapping("/getOrderListForm")
    public String getOrderListForm(){
        return "/order/orderListForm";
    }

    @GetMapping("/order/getOrderForm")
    public String getOrderForm(){
        return "/order/orderForm";
    }

    @PostMapping("/createOrder")
    public String createOrder(){
        return "redirect:/order/getOrderListForm";
    }


}
