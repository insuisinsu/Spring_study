package com.mybatis.join.VO;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SMybatisDAO {
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<SJoinVO> selectListSjoin(SJoinVO vo){
		System.out.println("selectListSjoin() 호출 성공");
		return mybatis.selectList("sjoin.selectListSjoin", vo);
	}
	
}
