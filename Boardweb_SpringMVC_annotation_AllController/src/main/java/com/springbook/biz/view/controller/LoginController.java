package com.springbook.biz.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController{

	@RequestMapping("/login.do")
	public String login(UserVO vo, UserDAO userDAO) {
		System.out.println("�α��� ó�� - Spring MVC annotation");
		
		if(userDAO.getUser(vo) != null) {
			return "redirect:getBoardList.do";
		}else {
			return "redirect:login.jsp";
		}
		
	}

}
