package com.springbook.biz.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class DeleteBoardController{
	
	// 삭제하고 끝, 다시 넘겨줄 vo 가 없기 때문에 ModelAndView 를 사용하지 않음
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO){
		System.out.println("글 삭제 처리- Spring MVC annotation");
		
		boardDAO.deleteBoard(vo);
		
		return "redirect:getBoardList.do";
		//그냥 getBoardList.do 를 요청하면 forward 로 넘겨줬기 때문에 삭제 이후에도 url 이 변경되지 않음
		//redirect:getBoardList.do 를 사용하여 url 바뀜
	}

}
