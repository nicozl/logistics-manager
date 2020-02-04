package com.zl.dto;

import com.zl.pojo.Customer;

/*
  *  客户的数据传输对象
 *
 * @version 2020年2月2日+上午10:05:10
 * @author zl
 */

public class CustomerDto extends BasePage{
	
	private Customer customer;
	
	//业务员
	private String salesMan;
	
	//常用区间
	private String interval;
	
	//订单个数
	private Integer orderNum;

	/**
	 * @return the orderNum
	 */
	public Integer getOrderNum() {
		return orderNum;
	}

	/**
	 * @param orderNum the orderNum to set
	 */
	public void setOrderNum(Integer orderNum) {
		this.orderNum = orderNum;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the salesMan
	 */
	public String getSalesMan() {
		return salesMan;
	}

	/**
	 * @param salesMan the salesMan to set
	 */
	public void setSalesMan(String salesMan) {
		this.salesMan = salesMan;
	}

	/**
	 * @return the interval
	 */
	public String getInterval() {
		return interval;
	}

	/**
	 * @param interval the interval to set
	 */
	public void setInterval(String interval) {
		this.interval = interval;
	}
	
	
	
}
