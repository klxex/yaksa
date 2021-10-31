package com.hwan.yaksa.item;

import com.hwan.yaksa.domain.Item;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;


public interface ItemService {
    public List<Item> searchItems(String keywords);
    public void insertItem(ItemDto itemDTO, MultipartFile multipartFile);
    public List<Item> findAllItem();
    public File searchImage(Long id);
    public Item searchItem(Long id);
}
