package com.hwan.yaksa.service;

import com.hwan.yaksa.authLogin.dto.SessionUser;
import com.hwan.yaksa.dto.BoardDto;
import com.hwan.yaksa.domain.Board;
import org.springframework.data.domain.Page;

public interface BoardService {
    public Board find(Long id);
    public Page<Board> findAll(Long boardNum);
    public void createBoard(BoardDto boardDTO, SessionUser sessionUser);
    public void delete(Long id);

}
