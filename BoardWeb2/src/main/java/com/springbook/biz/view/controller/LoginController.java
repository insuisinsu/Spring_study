package com.springbook.biz.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class LoginController implements Controller {

	@Override
	public String HandlerRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그인 처리 - Controller");
		
		// 1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");

		// 2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);

		UserDAO userDAO = new UserDAO();
		UserVO user = userDAO.getUser(vo);

		// 3. 화면 네비게이션
		//뷰페이지를 리턴함
		if (user != null) {
			return "getBoardList.do";
		} else {
			return "login.do";		//ViewResolver 페이지에서 뷰페이지를 완성함.
		}
		
		
	}

}
