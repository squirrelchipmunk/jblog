package com.javaex.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserDao userDao;
	@Autowired
	private BlogDao blogDao;
	
	
	public void join(UserVo userVo) {
		//회원가입
		int userNo = userDao.insertUser(userVo);		// 가입한 회원의 회원번호
		System.out.println(userNo);
		UserVo joinUser = userDao.selectUser(userNo);	// 회원번호로 id와 name 조회
		
		System.out.println(joinUser);
		//개인 블로그 생성
		BlogVo blogVo = new BlogVo();
		blogVo.setId(joinUser.getId());
		blogVo.setBlogTitle(joinUser.getUserName()+"의 블로그입니다.");
		blogDao.insertBlog( blogVo );
	}

	public UserVo login(UserVo userVo) {
		return userDao.selectAuthUser(userVo);
	}

	
	
}
