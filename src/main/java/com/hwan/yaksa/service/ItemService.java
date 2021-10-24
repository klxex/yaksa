package com.hwan.yaksa.service;

import com.hwan.yaksa.domain.Item;
import com.hwan.yaksa.dto.itemDto;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;


public interface ItemService {
    public List<Item> searchItems(String keywords);
    public void insertItem(itemDto itemDTO, MultipartFile multipartFile);
    public List<Item> findAllItem();
    public File searchImage(Long id);
}
