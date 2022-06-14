package com.springbook.biz.view.controller;

public class ViewResolver {
	//Controller에서 확장자를 제거하고 던져주는 뷰페이지를
	//확장자를 추가해서 처리함

	public String prefix;		// 리턴 받아 오는 이름 앞에 처리할 변수	//		./
	public String suffix;		// 리턴 받아 오는 이름 뒤에 처리할 변수//		.jsp
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	
	public String getView(String viewName) {
		return prefix + viewName + suffix;
	}
	
	
}
