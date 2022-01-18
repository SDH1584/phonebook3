package com.javaex.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/board")
public class Test {

	//메소드 일반
	@RequestMapping(value="/list",method= {RequestMethod.POST,RequestMethod.GET})
	public String TestPrint() {
	System.out.println("testprint");	
	
		return "/WEB-INF/views/Test.jsp";
	}
	
	@RequestMapping(value="/writeForm",method=RequestMethod.GET)
	public String TestPrint2() {
		System.out.println("testPrint2");
		return "/WEB-INF/views/Test.jsp";
	}
	@RequestMapping(value="/write",method=RequestMethod.GET)
	public String TestPrint3() {
		System.out.println("testPrint3");
		return "/WEB-INF/views/Test.jsp";
	}

}
