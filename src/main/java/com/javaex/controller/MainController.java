package com.javaex.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.javaex.service.SearchService;
import com.javaex.vo.SearchVo;

@Controller
public class MainController {
	@Autowired
	private SearchService searchService;

	
	@RequestMapping("/")
	public String main() {
		return "main/index";
	}

	@RequestMapping("/search")
	public String search(Model model, @RequestParam(value = "query", required=false,  defaultValue="") String query){
		List<SearchVo> searchList = searchService.Search(query);
		model.addAttribute("searchList",searchList);
		
		System.out.println(searchList);
		return "main/index";
	}
	
}
