package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.javaex.service.BlogService;
import com.javaex.service.CategoryService;
import com.javaex.service.PostService;
import com.javaex.vo.BlogVo;
import com.javaex.vo.CategoryVo;
import com.javaex.vo.PostVo;
import com.javaex.vo.UserVo;

@Controller
@RequestMapping(value="/{id}")
public class BlogController {

	@Autowired
	private BlogService blogService;
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private PostService postService;
	
	/* 블로그 공통 */
	@ModelAttribute("blogUser")
	public UserVo blogUser(@PathVariable("id") String id) {
		return blogService.getBlogUser(id);
	}
	
	@ModelAttribute("blogVo")
	public BlogVo blogVo(@PathVariable("id") String id) {
		return blogService.getBlog(id);
	}
	
	
	
	/* 블로그 메인 */
	@RequestMapping("")
	public String blogMain(@PathVariable("id") String id,
						   @RequestParam(value = "cateNo", required=false, defaultValue="0") int cateNo,
						   Model model) {
		List<CategoryVo> categoryList = categoryService.getCateList(id);
		//System.out.println(blogMap);
		model.addAttribute("categoryList",categoryList);
		
		List<PostVo> postList = postService.getList(id, cateNo);
		model.addAttribute("postList", postList);
		
		return "blog/blog-main";
	}
	
	/*
	@RequestMapping("/list")
	public String list(@PathVariable("id") String id,
					   @RequestParam("cateNo") int cateNo,
					   Model model){
		System.out.println(id);
		System.out.println(cateNo);
		
		List<PostVo> postList = postService.getList(id, cateNo);
		model.addAttribute("postList", postList);
		
		return "blog/blog-main";
	}
	*/
	
	
	/*  admin 페이지  */
	@RequestMapping("/admin/basic")
	public String adminBasic(@PathVariable("id") String id,
							 Model model) {
		BlogVo blogVo = blogService.getBlog(id);
		model.addAttribute("blogVo",blogVo);
		
		return "blog/admin/blog-admin-basic";
	}
	
	@RequestMapping("/modify")
	public String modify(@PathVariable("id") String id,
						@RequestParam("file") MultipartFile file,
						@ModelAttribute BlogVo blogVo) {
		blogService.modify(id, file, blogVo);
		
		return "redirect:admin/basic";
	}
	
	@RequestMapping("/admin/category")
	public String adminCategory() {
		return "blog/admin/blog-admin-cate";
	}
	
	@RequestMapping("/admin/writeForm")
	public String adminWriteForm(@PathVariable("id") String id,
							 	 Model model) {
		List<CategoryVo> categoryList = categoryService.getOptCateList(id);
		model.addAttribute("categoryList", categoryList);
		return "blog/admin/blog-admin-write";
	}
	
	@ResponseBody
	@RequestMapping("/getCateList")
	public List<CategoryVo> getAdminCateList(@PathVariable("id") String id){
		List<CategoryVo> categoryList = categoryService.getAdminCateList(id);
		return categoryList;
	}
	
}