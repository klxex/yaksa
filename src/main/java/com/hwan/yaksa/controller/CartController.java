package com.hwan.yaksa.controller;


import com.hwan.yaksa.authLogin.LoginUser;
import com.hwan.yaksa.authLogin.dto.SessionUser;
import com.hwan.yaksa.dto.CartResponseDto;
import com.hwan.yaksa.service.CartService;
import com.hwan.yaksa.dto.ItemDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
    public String addCartItem(Model model, @LoginUser SessionUser user, @ModelAttribute ItemDto itemDto,@RequestParam(name="quantity",required=false,defaultValue="1") int quantity){
        cartService.addCartItem(user,itemDto,quantity);
        return "redirect:/cart/cartForm";
    }

}
