package com.springbook.biz.view.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;
import com.springbook.biz.user.impl.UserService;

@Controller
public class UserController {
	
	//0.
	// userService 는 인터페이스이기 때문에, 이를 구현한 객체가 주입됨
	@Autowired
	private UserService userService;
	
	
	//1. 로그인 (GET 방식 처리 메소드)
	@RequestMapping (value = "/login.do", method = RequestMethod.GET)
	//public String loginView(UserVO vo)  {
	public String loginView(@ModelAttribute("user") UserVO vo)  {
		System.out.println("로그인 처리 (GET)- Spring MVC 호출 - Controller 통합");
		vo.setId("admin"); 
		vo.setPassword("1234"); 
		return "login.jsp";				//forward로 전송시 vo의 변수의 값이 잘 전달됨
		//return "redirect:login.jsp"; 
		
		//Command 객체에 변수의 값을 담아서 View 페지로 전송 할 수 있다. 
		//VO 객체의 클래스 이름은 UserVO , ${userVO.id} 뷰페이지에서 출력을 할 수 있다. 
	 /*
	  @ModelAttribute : Command 객체로 던져지는 객체 이름을 다른 이름으로 변경 (UserVO => user)
	  		view 페이지에서 출력시 : ${user.id}, ${user.password}
	   	
	  */
		
	}
	
	//1. 로그인 (POST 방식 처리 메소드)
	@RequestMapping (value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session)  {
		System.out.println("로그인 처리 (POST)- Spring MVC 호출 - Controller 통합");
		
		if (vo.getId() == null || vo.getId().equals("")) {
			//throw new NullPointerException ("Null 값은 넣을 수 없습니다. "); 
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다. ");
			//throw new ArithmeticException("0 값으로 나눌수 없습니다. "); 
		}     //vo에 id 변수의 값이 넘어오지 않으면 강제로 예외를 발생 시킴.....

		UserVO user = userDAO.getUser(vo);
		
		if (user != null) {
			session.setAttribute("userName", user.getName()); 
			return "getBoardList.do"; 
		}else {
			return "login.jsp"; 
		}
		
	}	
	
	//2. 로그 아웃 : Logout Controller 통합
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그 아웃 처리 - Spring MVC 호출 - Controller 통합");
		
		session.invalidate();	
		return "redirect:login.jsp"; 	
	}

	//3. 회원등록
	//GET
	@RequestMapping(value="/inserUser.do", method=RequestMethod.GET)
	public String insertView(UserVO vo) {
		return "insertUser.jsp";
	}
	
	//회원등록 폼에서 값을 넣고 전송 : DB 에 저장 - POST
	@RequestMapping(value="/insertUser.do", method = RequestMethod.POST)
	public String insertUser(UserVO vo) {
		System.out.println("회원 가입 성공 - UserController 의 insertUser() - Mybatis");
		userService.insertUser(vo);
		return "redirect:index.jsp";
	}
	
	
	//4. 회원 수정 (Update)
	@RequestMapping(value = "/updateUser.do", method = RequestMethod.GET)
	public String updateView(UserVO vo) {
		return "updateUser.jsp";
	}
	
	public String updateUser(UserVO vo) {
		userService.updateUser(vo);
		return "getUserList.do";
	}
	
	//5. 회원 탈퇴
		//회원 탈퇴 링크 클릭했을 때 - GET
	@RequestMapping(value="/deleteUser.do", method = RequestMethod.GET)
	public String deleteView(UserVO vo) {
		return "deluserUser.jsp";
	}
	
		//회원 탈퇴를 폼에서 POST 방식으로 전송했을 때
	public String deleteUser(UserVO vo) {
		userService.deleteUser(vo);
		return "getUserList.do";
	}
	
	
	//6. 회원 목록 출력
	public String getUserList(UserVO vo, Model model) {
		model.addAttribute("userList", userService.getUserList(vo));
		return "getUserList.jsp";
	}
	
	
}


















