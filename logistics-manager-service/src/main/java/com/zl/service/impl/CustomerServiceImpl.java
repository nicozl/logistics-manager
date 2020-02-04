package com.zl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zl.dto.CustomerDto;
import com.zl.mapper.CustomerMapper;
import com.zl.pojo.BasicData;
import com.zl.pojo.Customer;
import com.zl.pojo.CustomerExample;
import com.zl.pojo.Role;
import com.zl.pojo.User;
import com.zl.service.IBasicService;
import com.zl.service.ICustomerService;
import com.zl.service.IUserService;
import com.zl.utils.Constant;

/*
 * 
 *
 * @version 2020年1月31日+下午2:20:57
 * @author zl
 */

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Resource
	private CustomerMapper customerMapper;
	@Resource
	private IUserService userService;
	@Resource
	private IBasicService basicService;
	
	/**
	  *  新增客户
	 *  	查询 所有的角色是业务员的用户
	 *   	查询 常用区间 基础数据
	  *  修改客户
	  *  	查询 所有的角色是业务员的用户
	  *  	查询 常用区间 基础数据
	  *  	根据客户ID 查询详细信息 
	 */
	@Override
	public void getUpdateInfo(Integer id, Model m) {
		//查询所有具有业务员角色的用户信息
		List<User> users = userService.queryUserByRoleName(Constant.ROLE_SALESMAN);
		//查询 常用区间的基础数据		
		List<BasicData> intervals = basicService.getBasicDataByParentName(Constant.BASIC_COMMON_INTERVAL);
		if(id != null && id > 0) {
			Customer customer = new Customer();
			customer.setCustomerId(id);
			//查询更新需要的数据
			List<CustomerDto> list = customerMapper.queryView(customer);
			if(list !=null && list.size() == 1)
				m.addAttribute("dto", list.get(0));
		}
		m.addAttribute("users", users);
		m.addAttribute("intervals", intervals);
	}

	@Override
	public void addCustomer(Customer customer) {
		customerMapper.insertSelective(customer);
	}

	/**
	  *  当前用户如果是  业务员  只能查看所属的客户
	  *  如果是  操作员 或者 管理员  能查看所有的客户
	 */
	@Override
	public PageInfo<CustomerDto> queryPage(CustomerDto dto, User user) {
		PageHelper.startPage(dto.getPageNum(), dto.getPageSize());
		
		//获取角色信息
		List<Role> list = userService.queryRoleByUserId(user.getUserId());
		boolean flag = false;
		if(list != null && list.size() > 0) {
			for(Role role : list) {
				if(Constant.ROLE_ADMIN.equals(role.getRoleName()) || Constant.ROLE_OPERATOR.equals(role.getRoleName())) {
					//用户操作员或者管理员的身份，查询所有的客户信息
					flag = true;
					break;
				}
			}
		}
		//业务员 限制查询
		Customer customer = new Customer();
		if(flag == false) {
			customer.setUserId(user.getUserId());
		}
		List<CustomerDto> customers = customerMapper.queryView(customer);
		
		return new PageInfo<>(customers);
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerMapper.updateByPrimaryKey(customer);
	}

	@Override
	public void deleteCustomer(Integer id) {
		customerMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<Customer> query(Customer customer) {
		CustomerExample example = new CustomerExample();
		return customerMapper.selectByExample(example);
	}

	@Override
	public Integer queryBaseIdByCustomerId(Integer customerId) {
		Customer customer = customerMapper.selectByPrimaryKey(customerId);
		if(customer != null)
			return customer.getBaseId();
		return null;
	}

}
