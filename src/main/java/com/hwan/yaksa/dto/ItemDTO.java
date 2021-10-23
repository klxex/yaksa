package com.hwan.yaksa.dto;


import com.fasterxml.jackson.databind.jsonschema.JsonSerializableSchema;
import com.hwan.yaksa.domain.Image;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Getter
@Setter
public class ItemDTO {

    private String name;
    private String description;
    private int count;
    private int price;
    private FileDTO fileDTO;

    @Builder
    public ItemDTO(String name,String description,int count,int price,FileDTO fileDTO){
        this.name=name;
        this.description=description;
        this.count=count;
        this.price=price;
        this.fileDTO=fileDTO;

    }
}
