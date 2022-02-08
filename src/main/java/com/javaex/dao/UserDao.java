package com.javaex.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.UserVo;

@Repository
public class UserDao {

	@Autowired
	private SqlSession sqlSession;
	
	public int insertUser(UserVo userVo) {
		sqlSession.insert("user.insertUser",userVo);
		return userVo.getUserNo();
	}

	public UserVo selectAuthUser(UserVo userVo) {
		return sqlSession.selectOne("user.selectAuthUser",userVo);
	}

	public UserVo selectUser(int userNo) {
		return sqlSession.selectOne("user.selectUser", userNo);
	}

	
	
}
