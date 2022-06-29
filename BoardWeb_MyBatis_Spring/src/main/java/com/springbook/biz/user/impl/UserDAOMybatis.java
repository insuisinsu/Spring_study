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
	// 1. db 커넥션 정보
	// 2. user, board 의 mapper(실제 sql 쿼리)
	
	public void insertUser(UserVO vo) {
		System.out.println("Mybatis 를 사용해서 insertUser() 호출");
		mybatis.insert("UserDAO.insertUser", vo);
	}
	public void updateUser(UserVO vo) {
		System.out.println("Mybatis 를 사용해서 updateUser() 호출");
		mybatis.update("UserDAO.updateUser", vo);
	}
	public void deleteUser(UserVO vo) {
		System.out.println("Mybatis 를 사용해서 deleteUser() 호출");
		mybatis.delete("UserDAO.deleteUser", vo);
	}
	public UserVO getUser(UserVO vo) {
		System.out.println("Mybatis 를 사용해서 getUser() 호출");
		return (UserVO) mybatis.selectOne("UserDAO.getUser", vo);
	}
	public List<UserVO> getUserList(UserVO vo){
		System.out.println("Mybatis 를 사용해서 getUserList() 호출");
		return mybatis.selectList("UserDAO.getUserList", vo);
	}
}
