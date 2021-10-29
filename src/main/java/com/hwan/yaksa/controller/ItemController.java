package com.hwan.yaksa.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
