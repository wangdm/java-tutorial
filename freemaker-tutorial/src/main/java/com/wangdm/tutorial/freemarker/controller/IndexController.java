package com.wangdm.tutorial.freemarker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public String index(ModelMap model){
		model.addAttribute("hello", "Hello World");
		return "index";
	}
}
