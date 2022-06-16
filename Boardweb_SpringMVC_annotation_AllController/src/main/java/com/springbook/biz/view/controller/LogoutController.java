package com.springbook.biz.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LogoutController{
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그 아웃 처리 - Spring MVC annotation");
		
		session.invalidate();
		
		return "redirect:login.jsp";
		 
	}
}
