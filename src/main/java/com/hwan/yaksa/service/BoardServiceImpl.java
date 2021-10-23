package com.hwan.yaksa.service;

import com.hwan.yaksa.domain.Board;
import com.hwan.yaksa.dto.BoardDTO;
import com.hwan.yaksa.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final int SIZE=10;
    private final BoardRepository boardRepository;

    public void createBoard(BoardDTO boardDTO){
        Board board=new Board();
        board.setTitle(boardDTO.getTitle());
        board.setBoardContent(boardDTO.getBoardContent());
        boardRepository.save(board);
    }

    public Page<Board> findAll(Long boardNum){
        PageRequest pageRequest=PageRequest.of(boardNum.intValue()-1,SIZE);
        return boardRepository.findAll(pageRequest);

    }

    public Board find(Long id){
        return boardRepository.findById(id).get();
    }

    public void delete(Long id){

    }



}
