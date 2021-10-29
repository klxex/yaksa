package com.hwan.yaksa.board;


import com.hwan.yaksa.domain.Board;
import com.hwan.yaksa.domain.Comment;
import com.hwan.yaksa.domain.user.Account;
import com.hwan.yaksa.formLogin.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final AccountRepository accountRepository;

    public Comment addComment(CommentDto commentDto){
        Board board = boardRepository.findById(commentDto.getBoardId()).get();
        Account account = accountRepository.findByEmail(commentDto.getSessionUser().getEmail()).get();
        Comment comment= new Comment();
        comment.setBoard(board);
        comment.setAccount(account);
        comment.setContent(commentDto.getContent());
        board.addComments(comment);
        commentRepository.save(comment);

        return comment;
    }
}
