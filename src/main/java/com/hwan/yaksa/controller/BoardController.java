package com.hwan.yaksa.controller;


import com.hwan.yaksa.annotation.Auth;
import com.hwan.yaksa.authLogin.LoginUser;
import com.hwan.yaksa.authLogin.dto.SessionUser;
import com.hwan.yaksa.dto.BoardDto;
import com.hwan.yaksa.service.BoardServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class BoardController {
    private final BoardServiceImpl boardServiceImpl;

    @Auth
    @GetMapping("/searchBoard")
    public String searchBoard(@RequestParam(value="boardNum",required = false, defaultValue="1") Long boardNum,Model model){
        model.addAttribute("boardList",boardServiceImpl.findAll(boardNum));
        return "board/searchBoard";
    }

    @Auth
    @GetMapping("/board")
    public String getBoard(@RequestParam("id") Long boardNum, Model model) {

        model.addAttribute("board",boardServiceImpl.find(boardNum));
        return "board/boardForm";
    }

    @Auth
    @GetMapping("/createBoard")
    public String createBoard(Model model) {
        model.addAttribute("boardDTO", new BoardDto());
        return "board/createBoard";
    }

    @Auth
    @PostMapping("/createWord")
    public String createWord(@Valid  @ModelAttribute("boardDTO") BoardDto boardDTO, @LoginUser SessionUser sessionUser) {
         boardServiceImpl.createBoard(boardDTO,sessionUser);
         return "redirect:/searchBoard";

    }


}
