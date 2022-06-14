package com.springbook.biz.view.controller;

public class ViewResolver {
	//Controller���� Ȯ���ڸ� �����ϰ� �����ִ� ����������
	//Ȯ���ڸ� �߰��ؼ� ó����

	public String prefix;		// ���� �޾� ���� �̸� �տ� ó���� ����	//		./
	public String suffix;		// ���� �޾� ���� �̸� �ڿ� ó���� ����//		.jsp
	
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
