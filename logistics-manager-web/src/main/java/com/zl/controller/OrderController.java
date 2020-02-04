package com.zl.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zl.dto.OrderDto;
import com.zl.service.IOrderService;

/*
 * 
 *
 * @version 2020年2月3日+下午1:18:40
 * @author zl
 */

@Controller
@RequestMapping("/order")
public class OrderController {
	
	@Resource
	private IOrderService orderService;
	
	@RequestMapping("/orderUpdate")
	public String orderUpdate(Integer id, Model model) {
		orderService.getUpdateInfo(id, model);
		return "order/orderUpdate";
	}
	
	@RequestMapping("/save")
	@ResponseBody
	public String saveOrder(@RequestBody OrderDto dto) {
		orderService.addOrder(dto);
		return "success";
	}
}
