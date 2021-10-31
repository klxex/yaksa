package com.hwan.yaksa.controller;

import com.hwan.yaksa.domain.Item;
import com.hwan.yaksa.item.FileDto;
import com.hwan.yaksa.item.ItemDto;
import com.hwan.yaksa.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class ItemController {
    private final ItemService itemService;
    @GetMapping("/searchItem")
    public String searchItem(Model model) {

        return "item/searchItem";
    }


    @GetMapping("/createItem")
    public String createItem(Model model){
        return "item/createItem";
    }

    @GetMapping("/getItems/{id}")
    public String getItem(Model model, @PathVariable("id") Long id){
        Item item = itemService.searchItem(id);
        FileDto fileDTO= FileDto.builder()
                .id(item.getImage().getId())
                .name(item.getName())
                .build();

        ItemDto itemDto= ItemDto.builder()
                .id(item.getId())
                .name(item.getName())
                .count(item.getCount())
                .description(item.getDescription())
                .price(item.getPrice())
                .fileDTO(fileDTO)
                .build();

        model.addAttribute("itemDto",itemDto);
        return "item/itemForm";
    }
}
