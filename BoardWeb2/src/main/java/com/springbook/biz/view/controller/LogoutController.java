package com.springbook.biz.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogoutController implements Controller {

	@Override
	public String HandlerRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그아웃 처리");
		
		// 1. invatlidate() 로 세션값을 날려서 로그아웃 처리
		HttpSession session = request.getSession();
		session.invalidate();
		
		// 2. 占쏙옙占쏙옙 占쏙옙占쏙옙占쏙옙, 占쏙옙占쏙옙 화占쏙옙占쏙옙占쏙옙 占싱듸옙占싼댐옙.
		return "login";
	}

}
