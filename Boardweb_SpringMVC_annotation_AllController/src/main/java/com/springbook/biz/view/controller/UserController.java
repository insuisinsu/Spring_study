package com.springbook.biz.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class UserController {

	//�α��� - GET
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String loginView(UserVO vo) {
		System.out.println("�α��� ó�� - GET");
		vo.setId("admin");
		vo.setPassword("1234");
		return "redirect:login.jsp";
	}
	//�α��� - Post
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String loginView2(UserVO vo, UserDAO userDAO) {
		System.out.println("�α��� ó�� - POST");
		if(userDAO.getUser(vo) != null) {
			return "redirect:getBoardList.do";
		}else {
			return "redirect:login.jsp";
		}
	}
	
	
	
	//login Controller
//	@RequestMapping("/login.do")
//	public String login(UserVO vo, UserDAO userDAO) {
//		System.out.println("�α��� ó�� - Spring MVC annotation");
//		
//		if(userDAO.getUser(vo) != null) {
//			return "redirect:getBoardList.do";
//		}else {
//			return "redirect:login.jsp";
//		}
//	}
	
	//logout controller
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("�α� �ƿ� ó�� - Spring MVC annotation");
		
		session.invalidate();
		return "redirect:login.jsp";
	}
}
