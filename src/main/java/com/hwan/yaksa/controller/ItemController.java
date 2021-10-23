package com.hwan.yaksa.controller;

import com.hwan.yaksa.service.ItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class ItemController {
    @GetMapping("/searchItem")
    public String searchItem(Model model) {

        return "item/searchItem";
    }


    @GetMapping("/createItem")
    public String createItem(Model model){
        return "item/createItem";
    }
}
