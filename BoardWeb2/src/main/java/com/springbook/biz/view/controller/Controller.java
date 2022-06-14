package com.springbook.biz.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

// insterface 는 public abstract 가 생략되어 있음
	// 메소드 선언 : 하위의 모든 Controller 는 HandlerRequest() 를 재정의하여 사용
	String HandlerRequest(HttpServletRequest request, HttpServletResponse response);
		
		
		
}
