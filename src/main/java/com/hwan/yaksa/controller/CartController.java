package com.hwan.yaksa.controller;


import com.hwan.yaksa.authLogin.LoginUser;
import com.hwan.yaksa.authLogin.dto.SessionUser;
import com.hwan.yaksa.cart.CartRepository;
import com.hwan.yaksa.cart.CartRequestDto;
import com.hwan.yaksa.cart.CartResponseDto;
import com.hwan.yaksa.cart.CartService;
import com.hwan.yaksa.formLogin.AccountRepository;
import com.hwan.yaksa.item.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/cart")
@Controller
public class CartController {
    private final CartService cartService;

    @GetMapping("/cartForm")
    public String getCart(Model model, @LoginUser SessionUser user){
        CartResponseDto cartResponseDto = cartService.getCart(user);
        model.addAttribute("cartDto",cartResponseDto);
        return "cart/cartForm";
    }

    @PostMapping("/createCart")
    public String addCartItem(Model model, @LoginUser SessionUser user, @ModelAttribute ItemDto itemDto){
        cartService.addCartItem(user,itemDto);
        return "redirect:/cart/cartForm";
    }

}
