package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.SearchDao;
import com.javaex.vo.SearchVo;

@Service
public class SearchService {

	@Autowired
	private SearchDao searchDao;

	public List<SearchVo> Search(String query) {
		
		return searchDao.selectList(query);
	}
	
}
