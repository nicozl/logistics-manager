package com.zl.service;

import org.springframework.ui.Model;

import com.zl.dto.OrderDto;

/*
  *  查询添加订单或者修改订单需要查询的信息
 *
 * @version 2020年2月3日+下午1:19:31
 * @author zl
 */

public interface IOrderService {

	public void getUpdateInfo(Integer id, Model model);
	
	public void addOrder(OrderDto dto);
}
