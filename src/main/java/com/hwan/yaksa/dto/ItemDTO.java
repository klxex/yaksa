package com.hwan.yaksa.dto;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class itemDto {

    private String name;
    private String description;
    private int count;
    private int price;
    private FileDto fileDTO;

    @Builder
    public itemDto(String name, String description, int count, int price, FileDto fileDTO){
        this.name=name;
        this.description=description;
        this.count=count;
        this.price=price;
        this.fileDTO=fileDTO;

    }
}
