package com.hwan.yaksa.controller;


import com.hwan.yaksa.annotation.Auth;
import com.hwan.yaksa.domain.Item;
import com.hwan.yaksa.item.FileDto;
import com.hwan.yaksa.item.ItemDto;
import com.hwan.yaksa.item.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.LinkedList;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class ItemRestController {
    private final ItemService itemService;
    //@Value("${")
    static String dir_name;

    @Auth
    @GetMapping("/images/{id}")
    public ResponseEntity<InputStreamSource> download(@PathVariable("id") Long id,HttpServletResponse response){
        File file=itemService.searchImage(id);
        try{
            InputStreamResource resource=new InputStreamResource(new FileInputStream(file));
            HttpHeaders header=new HttpHeaders();
            header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+file.getName());
            header.add("Cache-Control", "no-cache, no-store, must-revalidate");
            header.add("Pragma", "no-cache");
            header.add("Expires", "0");
            return ResponseEntity.ok().headers(header).body(resource);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;

    }

    @Auth
    @GetMapping("/items")
    public List<ItemDto> searchItem(@RequestParam(value="query",required=false) String query){
        List<Item> items;
        List<ItemDto> itemDTOS = new LinkedList<>();
        if(query==null){
            items=itemService.findAllItem();
        }
        else{
            items=itemService.searchItems(query);
        }

        try{
            for(Item item:items){
                FileDto fileDTO= FileDto.builder()
                        .id(item.getImage().getId())
                        .name(item.getName())
                        .build();

                ItemDto itemDTO= ItemDto.builder()
                        .name(item.getName())
                        .count(item.getCount())
                        .description(item.getDescription())
                        .price(item.getPrice())
                        .fileDTO(fileDTO)
                        .build();

                itemDTOS.add(itemDTO);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return itemDTOS;
    }

    @PostMapping("/items")
    public ItemDto addItem(
            @RequestParam(value="name",required = false) String name,
            @RequestParam(value="description",required = false) String description,
            @RequestParam(value="count",required = false) int count,
            @RequestParam(value="price",required = false) int price,
            @RequestParam(value="file",required = true) MultipartFile multipartFile) {

        ItemDto itemDTO= ItemDto.builder()
                .name(name)
                .description(description)
                .count(count)
                .price(price)
                .build();

        itemService.insertItem(itemDTO,multipartFile);
        return  itemDTO;
    }


}
