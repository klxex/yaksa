package com.hwan.yaksa.board;

import com.hwan.yaksa.authLogin.dto.SessionUser;
import com.hwan.yaksa.domain.Board;
import com.hwan.yaksa.domain.user.Account;
import com.hwan.yaksa.formLogin.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final int SIZE=10;
    private final BoardRepository boardRepository;
    private final AccountRepository accountRepository;

    public void createBoard(BoardDto boardDTO, SessionUser sessionUser){
        Board board=new Board();
        board.setTitle(boardDTO.getTitle());
        board.setBoardContent(boardDTO.getBoardContent());
        Account account=accountRepository.findByEmail(sessionUser.getEmail()).get();
        account.createBoard(board);
        boardRepository.save(board);
    }

    public Page<Board> findAll(Long boardNum){
        PageRequest pageRequest=PageRequest.of(boardNum.intValue()-1,SIZE);
        return boardRepository.findAll(pageRequest);

    }

    public Board find(Long id){
        Board board = boardRepository.findById(id).get();
        board.incrementReadCount();
        return board;
    }

    public void delete(Long id){

    }



}
