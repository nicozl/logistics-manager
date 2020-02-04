package com.zl.controller;

import javax.annotation.Resource;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.zl.dto.CustomerDto;
import com.zl.pojo.Customer;
import com.zl.pojo.User;
import com.zl.service.ICustomerService;
import com.zl.utils.Constant;

/*
 * 
 *
 * @version 2020年2月1日+上午10:15:44
 * @author zl
 */

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	@Resource
	private ICustomerService customerService;
	
	@RequestMapping("/customerUpdate")
	public String customerUpdate(Integer id, Model model) {
		customerService.getUpdateInfo(id, model);
		return "customer/customerUpdate";
	}
	
	@RequestMapping("/saveOrUpdate")
	public String saveOrUpdate(Customer customer) throws Exception{
		if(customer.getCustomerId() != null && !"".equals(customer.getCustomerId())) {
			//更新
			customerService.updateCustomer(customer);
		}else {
			//添加
			customerService.addCustomer(customer);
		}
		return "success";
	}
	
	@RequestMapping("/query")
	public String query(CustomerDto dto, Model model) {
		User user = (User) SecurityUtils.getSubject().getPrincipal();
		System.out.println("---->" + user.getUserId());
		PageInfo<CustomerDto> list = customerService.queryPage(dto, user);
		model.addAttribute(Constant.PAGE_MODEL, list);
		return "customer/customer";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id) throws Exception{
		customerService.deleteCustomer(id);
		return "redirect:/customer/query";
	}
}
