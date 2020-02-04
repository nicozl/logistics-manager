package com.zl.controller;



import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zl.pojo.Role;
import com.zl.service.IRoleService;

/*
  * 角色 控制层
 * 
 * @version 2020年1月30日+上午8:43:59
 * @author zl
 *
 */

@Controller
@RequestMapping("/role")
public class RoleController {
	
	@Resource
	private IRoleService roleService;
	
	@RequestMapping("/query")
	public String query(Role role, Model model) {
		List<Role> list = roleService.query(role);
		model.addAttribute("list", list);
		return "role/role";
	}
	
}
