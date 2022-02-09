package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.BlogDao;
import com.javaex.dao.CategoryDao;
import com.javaex.dao.UserDao;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.UserVo;


@Service
public class BlogService {

	@Autowired
	private UserDao userDao;
	
	@Autowired
	private BlogDao blogDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	public UserVo getBlogUser(String id) {
		/* 블로그 user 가져오기 */
		return userDao.selectBlogUser(id);
	}
	
	public Map<String, Object> blogMain(String id) {
		
		Map <String, Object> blogMap = new HashMap<>();
		
		/* 블로그 정보 가져오기(title, logo) */
		BlogVo blogVo = blogDao.selectBlog(id);
		//System.out.println(blogVo);
		blogMap.put("blogVo", blogVo);
		
		/* 카테고리 리스트 */
		List<CategoryVo> categoryList = categoryDao.selectCateList(id);
		//System.out.println(categoryList);
		blogMap.put("categoryList", categoryList);
		
		return blogMap;
	}

	

}
