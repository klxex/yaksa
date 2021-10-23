package com.hwan.yaksa.dto;

import com.hwan.yaksa.domain.Board;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class BoardDTO {
    private String title;
    private String boardContent;

    public Board toEntity(){
        Board board = Board.builder().boardContent(boardContent).title(title).build();
        return board;
    }

    @Builder
    public BoardDTO(String title,String boardContent){
        this.title=title;
        this.boardContent=boardContent;
    }
}
