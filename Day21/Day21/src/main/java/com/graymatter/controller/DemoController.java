package com.graymatter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@ResponseBody  //json repr
public class DemoController {

	@RequestMapping("/hello")
	public ModelAndView sayHello()
	{
		ModelAndView mv= new ModelAndView("login");
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView doLogin(@RequestParam String uname, @RequestParam String pwd)
	{
		ModelAndView mv=null;
		if(uname.equals("dhanya") && pwd.equals("1212"))
			mv = new ModelAndView("welcome");
		else
		{
			mv = new ModelAndView("login");
		}
			return mv;
	}
}
