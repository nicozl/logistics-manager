package com.zl.dto;

import java.util.List;

import com.zl.pojo.Order;
import com.zl.pojo.OrderDetail;

/*
 * 
 *
 * @version 2020年2月3日+下午1:23:49
 * @author zl
 */

public class OrderDto extends Order{
	
	private List<OrderDetail> orderDetails;

	/**
	 * @return the orderDetails
	 */
	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	/**
	 * @param orderDetails the orderDetails to set
	 */
	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}
	
	
}
