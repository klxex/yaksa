package com.hwan.yaksa.restcontroller;


import com.hwan.yaksa.annotation.Auth;
import com.hwan.yaksa.domain.Image;
import com.hwan.yaksa.domain.Item;
import com.hwan.yaksa.dto.FileDTO;
import com.hwan.yaksa.dto.ItemDTO;
import com.hwan.yaksa.service.ItemService;
import com.hwan.yaksa.service.ItemServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.InputStreamSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.LinkedList;
import java.util.Map;
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
    public List<ItemDTO> searchItem(@RequestParam(value="query",required=false) String query){
        List<Item> items;
        List<ItemDTO> itemDTOs = new LinkedList<>();
        if(query==null){
            items=itemService.findAllItem();
        }
        else{
            items=itemService.searchItems(query);
        }

        try{
            for(Item item:items){
                FileDTO fileDTO=FileDTO.builder()
                        .id(item.getImage().getId())
                        .name(item.getName())
                        .build();

                ItemDTO itemDTO=ItemDTO.builder()
                        .name(item.getName())
                        .count(item.getCount())
                        .description(item.getDescription())
                        .price(item.getPrice())
                        .fileDTO(fileDTO)
                        .build();

                itemDTOs.add(itemDTO);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }

        return itemDTOs;
    }

    @PostMapping("/items")
    public ItemDTO addItem(
            @RequestParam(value="name",required = false) String name,
            @RequestParam(value="description",required = false) String description,
            @RequestParam(value="count",required = false) int count,
            @RequestParam(value="price",required = false) int price,
            @RequestParam(value="file",required = true) MultipartFile multipartFile) {

        ItemDTO itemDTO=ItemDTO.builder()
                .name(name)
                .description(description)
                .count(count)
                .price(price)
                .build();

        itemService.insertItem(itemDTO,multipartFile);
        return  itemDTO;
    }


}
