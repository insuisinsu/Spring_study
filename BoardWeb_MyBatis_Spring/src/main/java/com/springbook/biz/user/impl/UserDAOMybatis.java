package com.springbook.biz.user.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository
public class UserDAOMybatis implements UserService {

	@Autowired
	private SqlSessionFactory myBatis;
	// myBatis
	// 1. db Ŀ�ؼ� ����
	// 2. user, board �� mapper(���� sql ����)
	
	public void insertUser(UserVO vo) {
		System.out.println("Mybatis �� ����ؼ� insertUser() ȣ��");
		mybatis.insert("UserDAO.insertUser", vo);
	}
	public void updateUser(UserVO vo) {
		System.out.println("Mybatis �� ����ؼ� updateUser() ȣ��");
		mybatis.update("UserDAO.updateUser", vo);
	}
	public void deleteUser(UserVO vo) {
		System.out.println("Mybatis �� ����ؼ� deleteUser() ȣ��");
		mybatis.delete("UserDAO.deleteUser", vo);
	}
	public UserVO getUser(UserVO vo) {
		System.out.println("Mybatis �� ����ؼ� getUser() ȣ��");
		return (UserVO) mybatis.selectOne("UserDAO.getUser", vo);
	}
	public List<UserVO> getUserList(UserVO vo){
		System.out.println("Mybatis �� ����ؼ� getUserList() ȣ��");
		return mybatis.selectList("UserDAO.getUserList", vo);
	}
}
