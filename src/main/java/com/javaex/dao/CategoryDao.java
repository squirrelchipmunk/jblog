package com.javaex.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javaex.vo.CategoryVo;

@Repository
public class CategoryDao {

	@Autowired
	private SqlSession sqlSession;
	
	public void insertCategory(CategoryVo categoryVo) {
		sqlSession.insert("category.insertCategory", categoryVo);
	}
	
	public List<CategoryVo> selectCateList(String id) {
		return sqlSession.selectList("category.selectCateList", id);
	}


	public List<CategoryVo> selectAllDataList(String id) {
		return sqlSession.selectList("category.selectAllDataList", id);
	}

	public int selectPostNum(CategoryVo categoryVo) {
		return sqlSession.selectOne("category.selectPostNum", categoryVo);
	}

	public int delete(int cateNo) {
		return sqlSession.delete("category.delete",cateNo);
	}
	
}
