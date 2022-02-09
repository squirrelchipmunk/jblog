package com.javaex.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javaex.service.BlogService;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value="/{id}")
public class BlogController {

	@Autowired
	private BlogService blogService;
	
	@ModelAttribute("blogUser")
	public UserVo blogUser(@PathVariable("id") String id) {
		return blogService.getBlogUser(id);
	}
	
	@RequestMapping("")
	public String blogMain(@PathVariable("id") String id,
						   Model model) {
		Map<String, Object> blogMap = blogService.blogMain(id);
		//System.out.println(blogMap);
		model.addAttribute("map",blogMap);
		
		return "blog/blog-main";
	}
	
	
	
}
