package com.springbook.biz.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {

// insterface �� public abstract �� �����Ǿ� ����
	// �޼ҵ� ���� : ������ ��� Controller �� HandlerRequest() �� �������Ͽ� ���
	String HandlerRequest(HttpServletRequest request, HttpServletResponse response);
		
		
		
}
