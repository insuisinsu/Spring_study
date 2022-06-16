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
	
	// �����ϰ� ��, �ٽ� �Ѱ��� vo �� ���� ������ ModelAndView �� ������� ����
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO){
		System.out.println("�� ���� ó��- Spring MVC annotation");
		
		boardDAO.deleteBoard(vo);
		
		return "redirect:getBoardList.do";
		//�׳� getBoardList.do �� ��û�ϸ� forward �� �Ѱ���� ������ ���� ���Ŀ��� url �� ������� ����
		//redirect:getBoardList.do �� ����Ͽ� url �ٲ�
	}

}
