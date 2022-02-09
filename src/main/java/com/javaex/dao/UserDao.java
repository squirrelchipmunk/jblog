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

	public UserVo selectAuthUser(UserVo userVo) {	// 세션 UserVo
		return sqlSession.selectOne("user.selectAuthUser",userVo);
	}

	public UserVo selectUser(int userNo) {			// 블로그 생성 UserVo
		return sqlSession.selectOne("user.selectUser", userNo);
	}

	public int selectUidCnt(String id) {			// 중복체크 count
		return sqlSession.selectOne("user.selectUidCnt", id);
	}

	public UserVo selectBlogUser(String id) {	// 블로그 UserVo
		return sqlSession.selectOne("user.selectBlogUser", id);
	}

	
	
}
