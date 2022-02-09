package com.javaex.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.CategoryService;
import com.javaex.vo.CategoryVo;

@Controller
@RequestMapping("/category")
public class CategoryController {


	@Autowired
	private CategoryService categoryService;
	

	@ResponseBody
	@RequestMapping("/remove")
	public String remove(@RequestParam("cateNo") int cateNo) { 
		return categoryService.remove(cateNo);
	}
}
