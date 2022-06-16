package com.springbook.biz.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

@Controller
public class GetBoardController {
	
	@RequestMapping("/getBoard.do")		//(value="/getBoard.do") �ε� value �� ���� ����
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("�� �� ��ȸ ó��- Spring MVC annotation ó��");
		
		System.out.println("�� ���� VO�� �ڵ����� �Ѿ. " + vo.getSeq()+" �� �Խñ�");
		
		mav.addObject("board", boardDAO.getBoard(vo)); 
		mav.setViewName("getBoard.jsp");  //forward�� �̵� ��	//viewResolver �� ���� ������ jsp �������� �״�� ������
		return mav ; 
		
		
	}

}
