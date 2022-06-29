package com.springbook.biz.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbook.biz.user.UserVO;


// ����Ͻ� ������ ó���ϴ� ���� Ŭ���� : @Service

@Service("userService")
public class UserServiceImpl implements UserService {
	
	//���� ������ ���� ó���ϵ��� ����
	@Autowired
	private UserDAOMybatis userDAO;

	@Override
	public void insertUser(UserVO vo) {
		userDAO.insertUser(vo);
	}

	@Override
	public void updateUser(UserVO vo) {
		userDAO.updateUser(vo);
	}

	@Override
	public void deleteUser(UserVO vo) {
		userDAO.deleteUser(vo);
	}

	@Override
	public UserVO getUser(UserVO vo) {
		return 	userDAO.getUser(vo);
	}

	@Override
	public List<UserVO> getUserList(UserVO vo) {
		return 	userDAO.getUserList(vo);
	}

}
