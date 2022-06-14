package com.springbook.biz.view.controller;

import java.util.HashMap;
import java.util.Map;

public class HandlerMapping {	//클라이언트 요청에 대한 Controller 매핑

	private Map<String, Controller> mappings;		// 객쳅 변수 선언 (Map은 인터페이스 이기 때문에 실행부 ㄴㄴ)
	
	//기본 생성자
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();	// HashMap : Map 을 구현하는 클래스
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/getBoard.do", new GetBoardController());
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());

	}
	// path 를 받아서 위에 mappings 에 담아놓은 Controller 를 찾아서 가져옴
	public Controller getController(String path) {
		return mappings.get(path);
		
	}
}
