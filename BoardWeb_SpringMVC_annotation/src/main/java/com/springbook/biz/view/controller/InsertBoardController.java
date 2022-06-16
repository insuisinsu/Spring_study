package com.springbook.biz.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController  {
	//xml 세팅 처럼 Controller 인터페이스를 상속하지 않기 때문에 원하는대로 메소드 세팅 가능함
	
	@RequestMapping(value="/insertBoard.do")   // 클라이언트 요청 
	public String insertBoard(BoardVO vo, BoardDAO boardDAO)  {
		System.out.println("글 등록 처리- Spring MVC 어노테이션 작동 ");
		//Spring Framework 가 폼에서 넘긴 값을 setter 다 해줌
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";   //Forward 방식으로 뷰 페이지 전송 
		 
	}

}

/* xml 세팅으로 할 경우
public class InsertBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		System.out.println("글 등록 처리- Spring MVC 호출 - Controller 분리");
		
		// 1. 사용자 입력 정보 추출
		// request.setCharacterEncoding("EUC-KR");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);
		
		// 3. 화면 네비게이션
		
		ModelAndView mav = new ModelAndView();
		
		 mav.setViewName("getBoardList.do");
		 return mav; 
		 
		 
	}

}

*/