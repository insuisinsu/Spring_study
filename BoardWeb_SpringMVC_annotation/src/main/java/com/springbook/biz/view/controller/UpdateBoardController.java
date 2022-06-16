package com.springbook.biz.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class UpdateBoardController {
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO){
		System.out.println("글 수정 처리 - Spring MVC annotation");
		
		boardDAO.updateBoard(vo);
		
		return "redirect:getBoardList.do"; 
		 
		 
	
	}

}
