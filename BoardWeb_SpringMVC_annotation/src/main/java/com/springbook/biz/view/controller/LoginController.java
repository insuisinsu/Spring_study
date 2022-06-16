package com.springbook.biz.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

public class LoginController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) 
	throws Exception {
		System.out.println("로그인 처리 - Spring MVC 호출 - Controller 분리");
		
		// 1. 사용자 입력 정보 추출
					String id = request.getParameter("id");
					String password = request.getParameter("password");

					// 2. DB 연동 처리
					UserVO vo = new UserVO();
					vo.setId(id);
					vo.setPassword(password);

					UserDAO userDAO = new UserDAO();
					UserVO user = userDAO.getUser(vo);

					// 3. 화면 네비게이션  (뷰 페이지를 돌려줌 )
					ModelAndView mav = new ModelAndView(); 
									
					if (user != null) {
						mav.setViewName("redirect:getBoardList.do");
						//redirect : viewResolver 설정을 무시하고 리다이렉트 한다. 
						//redirect : viewResolver의 prefix, suffix 가 적용되지 않도록 한다. 
						
						//기본적은 Controller가 View페이지를 던지는 방식은 Forward 방식입니다.
							//클라이언트의 URL이 바뀌지 않는다. 
							//viewResolver가 작동이 된다.    prefix, suffix 가 적용 
						//redirect : 서버에서 전송한 페이지를 client가 재요청 
							//클라이언트의 URL이 바뀐다. 
							//viewResolver 가 작동이 안된다.
						
								
						return mav;
					} else {
						 mav.setViewName("redirect:login.jsp");   // ViewResolver 페이지에서 뷰페이지를 완성함. 
						 return mav; 
					}
					
		
	
	}

}
