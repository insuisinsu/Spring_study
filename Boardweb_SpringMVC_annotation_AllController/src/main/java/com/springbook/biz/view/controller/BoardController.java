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

	//��ɺ� Controller ����
	
	//getBoardList Controller
	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("�� ��� �˻� ó�� -- Spring MVC ������̼� �۵� ");

		mav.addObject("boardList", boardDAO.getBoardList(vo)); 
		mav.setViewName("getBoardList.jsp");  //forward�� �̵� ��
		return mav ; 
	}
	
	//getBoard Controller
	@RequestMapping("/getBoard.do")		//(value="/getBoard.do") �ε� value �� ���� ����
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("�� �� ��ȸ ó��- Spring MVC annotation ó��");
		
		System.out.println("�� ���� VO�� �ڵ����� �Ѿ. " + vo.getSeq()+" �� �Խñ�");
		
		mav.addObject("board", boardDAO.getBoard(vo)); 
		mav.setViewName("getBoard.jsp");  //forward�� �̵� ��	//viewResolver �� ���� ������ jsp �������� �״�� ������
		return mav ; 
	}
	
	//insertBoard Controller
	@RequestMapping(value="/insertBoard.do")   // Ŭ���̾�Ʈ ��û //value �� ���� ����
	public String insertBoard(BoardVO vo, BoardDAO boardDAO)  {
		System.out.println("�� ��� ó��- Spring MVC ������̼� �۵� ");
		
		boardDAO.insertBoard(vo);
		return "getBoardList.do";   //Forward ������� �� ������ ���� 
	}
	
	//updateBoard Controller
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO){
		System.out.println("�� ���� ó�� - Spring MVC annotation");
		
		boardDAO.updateBoard(vo);
		return "redirect:getBoardList.do"; 
	}
	
	//deleteBoard Controller
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO){
		System.out.println("�� ���� ó��- Spring MVC annotation");
		
		boardDAO.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
	
}
