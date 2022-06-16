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
	//xml ���� ó�� Controller �������̽��� ������� �ʱ� ������ ���ϴ´�� �޼ҵ� ���� ������
	
	@RequestMapping(value="/insertBoard.do")   // Ŭ���̾�Ʈ ��û 
	public String insertBoard(BoardVO vo, BoardDAO boardDAO)  {
		System.out.println("�� ��� ó��- Spring MVC ������̼� �۵� ");
		//Spring Framework �� ������ �ѱ� ���� setter �� ����
		boardDAO.insertBoard(vo);
		
		return "getBoardList.do";   //Forward ������� �� ������ ���� 
		 
	}

}

/* xml �������� �� ���
public class InsertBoardController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) 
			throws Exception {
		System.out.println("�� ��� ó��- Spring MVC ȣ�� - Controller �и�");
		
		// 1. ����� �Է� ���� ����
		// request.setCharacterEncoding("EUC-KR");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		// 2. DB ���� ó��
		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		
		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);
		
		// 3. ȭ�� �׺���̼�
		
		ModelAndView mav = new ModelAndView();
		
		 mav.setViewName("getBoardList.do");
		 return mav; 
		 
		 
	}

}

*/