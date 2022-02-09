package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.javaex.service.PostService;
import com.javaex.vo.PostVo;

@Controller
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostService postService;
	
	@ResponseBody
	@RequestMapping("/list")
	public List<PostVo> list(@RequestParam("id")String id,
							 @RequestParam("cateNo")int cateNo){
		System.out.println(id);
		System.out.println(cateNo);
		
		List<PostVo> list = postService.getList(id, cateNo);
		System.out.println(list);
		return list;
	}
	
}
