package com.javaex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javaex.dao.CategoryDao;
import com.javaex.vo.CategoryVo;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao categoryDao;

	public List<CategoryVo> getCateList(String id) {
		
		
		/* 블로그 정보 가져오기(title, logo) */
		//BlogVo blogVo = blogDao.selectBlog(id);
		//System.out.println(blogVo);
		//blogMap.put("blogVo", blogVo);
		
		/* 카테고리 리스트 */
		return categoryDao.selectCateList(id);
	}
	
	public List<CategoryVo> getAllDataList(String id){
		List<CategoryVo> cateList = categoryDao.selectAllDataList(id);
		for(CategoryVo vo: cateList) {
			
			CategoryVo cVo = new CategoryVo();
			cVo.setCateNo(vo.getCateNo());
			cVo.setId(id);
			int postNum = categoryDao.selectPostNum( cVo );
			vo.setPostNum(postNum);
		}
		
		return cateList;
	}

	public String remove(int cateNo) {
		int count = categoryDao.delete(cateNo);
		if(count>0)
			return "seccess";
		else
			return "fail";
	}
	
}
