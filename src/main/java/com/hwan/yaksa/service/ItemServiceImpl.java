package com.hwan.yaksa.service;

import com.hwan.yaksa.domain.Image;
import com.hwan.yaksa.domain.Item;
import com.hwan.yaksa.dto.ItemDto;
import com.hwan.yaksa.repository.ImageRepository;
import com.hwan.yaksa.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService {
    static Path p= Paths.get(".");
    @Value("${path.local}")
    private String LOCAL_DIR;
    private final ItemRepository itemRepository;
    private final ImageRepository imageRepository;

    public List<Item> searchItems(String keywords){
        itemRepository.findByNameContaining(keywords);
        return null;
    }

    public File searchImage(Long id){
        Image image=imageRepository.findById(id).get();
        File file=new File(LOCAL_DIR+File.separator+image.getName());
        return file;
    }

    public Item searchItem(Long id){
        return itemRepository.findById(id).get();
    }

    public void insertItem(ItemDto itemDTO, MultipartFile multipartFile){
       Image image=Image.builder()
            .dir(LOCAL_DIR)
            .name(multipartFile.getOriginalFilename())
            .build();

        imageRepository.save(image);
        Long id = image.getId();
        String ext=multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().indexOf("."));
        image.setName(id+ext);

        try {
            File dir = new File(LOCAL_DIR);
            File file = new File(LOCAL_DIR+File.separator+id+ext);

            if(!dir.exists()){
                dir.mkdirs();
            }

            file.createNewFile();
            FileOutputStream fos=new FileOutputStream(file);
            fos.write(multipartFile.getBytes());
            fos.close();
        }
        catch(Exception e){
            e.printStackTrace();

        }



        Item item = Item.builder()
                .name(itemDTO.getName())
                .image(image)
                .price(itemDTO.getPrice())
                .count(itemDTO.getCount())
                .description(itemDTO.getDescription())
                .build();

        itemRepository.save(item);
    }

    public List<Item> findAllItem(){
        return itemRepository.findAll();
    }

}
