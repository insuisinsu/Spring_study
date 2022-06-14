package com.springbook.biz.view.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {	//Ŭ���̾�Ʈ ��û�� ���� Controller ����

	private Map<String, Controller> mappings;		// ���� ���� ���� (Map�� �������̽� �̱� ������ ����� ����)
	
	//�⺻ ������
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();	// HashMap : Map �� �����ϴ� Ŭ����
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());

	}
	// path �� �޾Ƽ� ���� mappings �� ��Ƴ��� Controller �� ã�Ƽ� ������
	public Controller getController(String path) {
		return mappings.get(path);
		
	}
}
