package com.hwan.yaksa.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class CommentResponseDto {
    private String content;
    private String name;

    @Builder
    public CommentResponseDto(String content, String name) {
        this.content = content;
        this.name = name;
    }
}
