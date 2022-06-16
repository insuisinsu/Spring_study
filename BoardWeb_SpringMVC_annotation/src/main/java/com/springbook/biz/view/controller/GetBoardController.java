package com.springbook.biz.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class GetBoardController {
	
	@RequestMapping("/getBoard.do")		//(value="/getBoard.do") 인데 value 는 생략 가능
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 상세 조회 처리- Spring MVC annotation 처리");
		
		System.out.println("폼 값이 VO로 자동으로 넘어감. " + vo.getSeq()+" 번 게시글");
		
		mav.addObject("board", boardDAO.getBoard(vo)); 
		mav.setViewName("getBoard.jsp");  //forward로 이동 됨	//viewResolver 가 없기 때문에 jsp 페이지를 그대로 던져줌
		return mav ; 
		
		
	}

}
