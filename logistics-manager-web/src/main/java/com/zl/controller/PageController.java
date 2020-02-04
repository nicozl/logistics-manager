package com.zl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * @version 2020年1月29日+下午10:29:41
 * @author zl
 * 
 *	页面控制器
 */

@Controller
public class PageController {
	
	/**
	  *  跟目录就跳转到main.jsp页面
	 * @return
	 */
	@RequestMapping("/")
	public String showMain() {
		return "login";
	}
	
	/**
	 * restful 风格
	 *    传递的是什么数据就跳转到对应的页面
	 * @param path
	 * @return
	 */
	@RequestMapping("/{path}")
	public String showTop(@PathVariable String path){
		return path;
	}
}
