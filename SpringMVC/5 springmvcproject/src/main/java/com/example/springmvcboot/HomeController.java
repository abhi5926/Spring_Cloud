package com.example.springmvcboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springmvcboot.model.Alien;

@Controller
public class HomeController
{
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	
	
	@RequestMapping("add")
	public String add(@RequestParam("num1")int i ,@RequestParam("num2") int j, Model m)
	{
		
	
		int num3 = i + j;
		
		m.addAttribute("num3",num3);
		
		return  "result";
		
	}
	
	@RequestMapping("addAlien")
	public String addAlien(Alien a , Model m)
	{
		
		m.addAttribute("alien",a);
		return "result";
		
	}
}
