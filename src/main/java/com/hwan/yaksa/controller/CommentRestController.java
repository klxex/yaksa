package com.hwan.yaksa.controller;

import com.hwan.yaksa.authLogin.LoginUser;
import com.hwan.yaksa.authLogin.dto.SessionUser;
import com.hwan.yaksa.domain.Board;
import com.hwan.yaksa.domain.Comment;
import com.hwan.yaksa.dto.CommentDto;
import com.hwan.yaksa.dto.CommentResponseDto;
import com.hwan.yaksa.service.BoardService;
import com.hwan.yaksa.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class CommentRestController {
    private final CommentService commentService;
    private final BoardService boardService;

    @PostMapping("/comments")
    public void createComment(@RequestParam("content") String content,@RequestParam("boardId") long boardId, @LoginUser SessionUser sessionUser){

        CommentDto commentDto = CommentDto.builder()
                                .content(content)
                                .sessionUser(sessionUser)
                                .boardId(boardId)
                                .build();

        Comment comment = commentService.addComment(commentDto);

    }

    @GetMapping("/board/{id}/comments")
    public List<CommentResponseDto> getAllComments(@PathVariable("id") Long id){
            Board board=boardService.find(id);
            List<CommentResponseDto> commentResponseDtos = new ArrayList<>();
            List<Comment> comments = board.getComments();

            for(Comment comment:comments){
                CommentResponseDto commentResponseDto = CommentResponseDto.builder()
                        .name(comment.getAccount().getName())
                        .content(comment.getContent())
                        .build();

                commentResponseDtos.add(commentResponseDto);
            }

            return commentResponseDtos;
    }


}
