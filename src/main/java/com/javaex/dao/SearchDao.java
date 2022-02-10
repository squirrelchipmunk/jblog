package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.SearchVo;

@Repository
public class SearchDao {

	@Autowired
	private SqlSession sqlSession;

	public List<SearchVo> selectList(String query) {
		return sqlSession.selectList("search.selectList", query);
	}
}
