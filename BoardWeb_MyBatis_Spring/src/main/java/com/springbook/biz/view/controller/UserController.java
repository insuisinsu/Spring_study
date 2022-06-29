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
	// userService �� �������̽��̱� ������, �̸� ������ ��ü�� ���Ե�
	@Autowired
	private UserService userService;
	
	
	//1. �α��� (GET ��� ó�� �޼ҵ�)
	@RequestMapping (value = "/login.do", method = RequestMethod.GET)
	//public String loginView(UserVO vo)  {
	public String loginView(@ModelAttribute("user") UserVO vo)  {
		System.out.println("�α��� ó�� (GET)- Spring MVC ȣ�� - Controller ����");
		vo.setId("admin"); 
		vo.setPassword("1234"); 
		return "login.jsp";				//forward�� ���۽� vo�� ������ ���� �� ���޵�
		//return "redirect:login.jsp"; 
		
		//Command ��ü�� ������ ���� ��Ƽ� View ������ ���� �� �� �ִ�. 
		//VO ��ü�� Ŭ���� �̸��� UserVO , ${userVO.id} ������������ ����� �� �� �ִ�. 
	 /*
	  @ModelAttribute : Command ��ü�� �������� ��ü �̸��� �ٸ� �̸����� ���� (UserVO => user)
	  		view ���������� ��½� : ${user.id}, ${user.password}
	   	
	  */
		
	}
	
	//1. �α��� (POST ��� ó�� �޼ҵ�)
	@RequestMapping (value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session)  {
		System.out.println("�α��� ó�� (POST)- Spring MVC ȣ�� - Controller ����");
		
		if (vo.getId() == null || vo.getId().equals("")) {
			//throw new NullPointerException ("Null ���� ���� �� �����ϴ�. "); 
			throw new IllegalArgumentException("���̵�� �ݵ�� �Է��ؾ� �մϴ�. ");
			//throw new ArithmeticException("0 ������ ������ �����ϴ�. "); 
		}     //vo�� id ������ ���� �Ѿ���� ������ ������ ���ܸ� �߻� ��Ŵ.....

		UserVO user = userDAO.getUser(vo);
		
		if (user != null) {
			session.setAttribute("userName", user.getName()); 
			return "getBoardList.do"; 
		}else {
			return "login.jsp"; 
		}
		
	}	
	
	//2. �α� �ƿ� : Logout Controller ����
	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("�α� �ƿ� ó�� - Spring MVC ȣ�� - Controller ����");
		
		session.invalidate();	
		return "redirect:login.jsp"; 	
	}

	//3. ȸ�����
	//GET
	@RequestMapping(value="/inserUser.do", method=RequestMethod.GET)
	public String insertView(UserVO vo) {
		return "insertUser.jsp";
	}
	
	//ȸ����� ������ ���� �ְ� ���� : DB �� ���� - POST
	@RequestMapping(value="/insertUser.do", method = RequestMethod.POST)
	public String insertUser(UserVO vo) {
		System.out.println("ȸ�� ���� ���� - UserController �� insertUser() - Mybatis");
		userService.insertUser(vo);
		return "redirect:index.jsp";
	}
	
	
	//4. ȸ�� ���� (Update)
	@RequestMapping(value = "/updateUser.do", method = RequestMethod.GET)
	public String updateView(UserVO vo) {
		return "updateUser.jsp";
	}
	
	public String updateUser(UserVO vo) {
		userService.updateUser(vo);
		return "getUserList.do";
	}
	
	//5. ȸ�� Ż��
		//ȸ�� Ż�� ��ũ Ŭ������ �� - GET
	@RequestMapping(value="/deleteUser.do", method = RequestMethod.GET)
	public String deleteView(UserVO vo) {
		return "deluserUser.jsp";
	}
	
		//ȸ�� Ż�� ������ POST ������� �������� ��
	public String deleteUser(UserVO vo) {
		userService.deleteUser(vo);
		return "getUserList.do";
	}
	
	
	//6. ȸ�� ��� ���
	public String getUserList(UserVO vo, Model model) {
		model.addAttribute("userList", userService.getUserList(vo));
		return "getUserList.jsp";
	}
	
	
}

















