package com.springbook.biz.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;
import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class BoardController {

	//기능별 Controller 통합
	
	//getBoardList Controller
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 목록 검색 처리 -- Spring MVC 어노테이션 작동 ");

		mav.addObject("boardList", boardDAO.getBoardList(vo)); 
		mav.setViewName("getBoardList.jsp");  //forward로 이동 됨
		return mav ; 
	}
	
	//getBoard Controller
	@RequestMapping("/getBoard.do")		//(value="/getBoard.do") 인데 value 는 생략 가능
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 상세 조회 처리- Spring MVC annotation 처리");
		
		System.out.println("폼 값이 VO로 자동으로 넘어감. " + vo.getSeq()+" 번 게시글");
		
		mav.addObject("board", boardDAO.getBoard(vo)); 
		mav.setViewName("getBoard.jsp");  //forward로 이동 됨	//viewResolver 가 없기 때문에 jsp 페이지를 그대로 던져줌
		return mav ; 
	}
	
	//insertBoard Controller
	@RequestMapping(value="/insertBoard.do")   // 클라이언트 요청 //value 는 생략 가능
	public String insertBoard(BoardVO vo, BoardDAO boardDAO)  {
		System.out.println("글 등록 처리- Spring MVC 어노테이션 작동 ");
		
		boardDAO.insertBoard(vo);
		return "getBoardList.do";   //Forward 방식으로 뷰 페이지 전송 
	}
	
	//updateBoard Controller
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO){
		System.out.println("글 수정 처리 - Spring MVC annotation");
		
		boardDAO.updateBoard(vo);
		return "redirect:getBoardList.do"; 
	}
	
	//deleteBoard Controller
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO){
		System.out.println("글 삭제 처리- Spring MVC annotation");
		
		boardDAO.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
	
}
