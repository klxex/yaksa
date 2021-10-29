package com.hwan.yaksa.item;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class FileDto {
    public Long id;
    public String name;
    public String contentType;


    @Builder
    public FileDto(Long id, String name, String contentType){
        this.id=id;
        this.name=name;
        this.contentType=contentType;
    }
}
