package com.hwan.yaksa.board;

import com.hwan.yaksa.authLogin.dto.SessionUser;
import com.hwan.yaksa.domain.Board;
import com.hwan.yaksa.domain.Comment;
import com.hwan.yaksa.domain.user.Account;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter @Setter
@NoArgsConstructor
public class CommentDto implements Serializable {
    private String content;
    private SessionUser sessionUser;
    private long boardId;

    @Builder
    public CommentDto(String content, SessionUser sessionUser, long boardId) {
        this.content = content;
        this.sessionUser = sessionUser;
        this.boardId = boardId;
    }
}
