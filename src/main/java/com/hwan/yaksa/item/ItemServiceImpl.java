package com.hwan.yaksa.item;

import com.hwan.yaksa.domain.Image;
import com.hwan.yaksa.domain.Item;
import lombok.RequiredArgsConstructor;
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
    static Path p= Paths.get("");
    static String LOCAL_DIR=p.toAbsolutePath().toString()+"/img";
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

    public void insertItem(ItemDto itemDTO, MultipartFile multipartFile){
        try {
            File dir = new File(LOCAL_DIR);
            File file = new File(LOCAL_DIR+File.separator+multipartFile.getOriginalFilename());

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

        Image image=Image.builder()
                .dir(LOCAL_DIR)
                .name(multipartFile.getOriginalFilename())
                .build();

        imageRepository.save(image);

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
