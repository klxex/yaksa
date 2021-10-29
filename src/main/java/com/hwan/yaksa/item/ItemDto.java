package com.hwan.yaksa.item;


import com.hwan.yaksa.item.FileDto;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ItemDto {

    private String name;
    private String description;
    private int count;
    private int price;
    private FileDto fileDTO;

    @Builder
    public ItemDto(String name, String description, int count, int price, FileDto fileDTO){
        this.name=name;
        this.description=description;
        this.count=count;
        this.price=price;
        this.fileDTO=fileDTO;

    }
}
