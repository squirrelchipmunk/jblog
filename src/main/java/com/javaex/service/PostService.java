package com.javaex.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.PostDao;
import com.javaex.vo.PostVo;

@Service
public class PostService {

	@Autowired
	private PostDao postDao;

	public List<PostVo> getList(String id, int cateNo) {
		Map <String, Object> map = new HashMap<>();
		map.put("id", id);
		map.put("cateNo", cateNo);
		
		return postDao.selectList(map);
	}

	public PostVo read(int postNo) {
		return postDao.selectPost(postNo);
	}
	
}
