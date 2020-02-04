package com.zl.service;

import java.util.List;

import org.springframework.ui.Model;

import com.github.pagehelper.PageInfo;
import com.zl.dto.CustomerDto;
import com.zl.pojo.Customer;
import com.zl.pojo.User;

/*
 * 
 *
 * @version 2020年1月31日+下午2:19:23
 * @author zl
 */

public interface ICustomerService {

	/**
	  *  查询更新或者添加需要的信息
	 * @param id
	 * @param m
	 */
	public void getUpdateInfo(Integer id, Model m);
	
	public void addCustomer(Customer customer);
	
	/**
	  *  分页查询
	 * @param dto
	 * @param user
	 * @return
	 */
	public PageInfo<CustomerDto> queryPage(CustomerDto dto, User user);
	
	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(Integer id);
	
	/**
	  *  查询客户信息
	 * @param customer
	 * @return
	 */
	public List<Customer> query(Customer customer);
	
	/**
	  *  根据客户id查询对应的基础数据id
	 * @param customerId
	 * @return
	 */
	public Integer queryBaseIdByCustomerId(Integer customerId);
	
}
