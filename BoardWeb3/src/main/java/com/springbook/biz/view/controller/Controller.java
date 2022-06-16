package com.springbook.biz.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	
	//메소드 선언 : 하위의 모든 Controller는 HandlerRequest 메소드를 재정의 
	 String handlerRequest(HttpServletRequest request, HttpServletResponse response);

}
