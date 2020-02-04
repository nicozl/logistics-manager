package com.zl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.zl.dto.OrderDto;
import com.zl.mapper.OrderDetailMapper;
import com.zl.mapper.OrderMapper;
import com.zl.pojo.BasicData;
import com.zl.pojo.Customer;
import com.zl.pojo.OrderDetail;
import com.zl.pojo.User;
import com.zl.service.IBasicService;
import com.zl.service.ICustomerService;
import com.zl.service.IOrderService;
import com.zl.service.IUserService;
import com.zl.utils.Constant;

/*
 * 
 *
 * @version 2020年2月3日+下午1:20:10
 * @author zl
 */

@Service
public class OrderServiceImpl implements IOrderService {

	@Resource
	private OrderMapper orderMapper;
	@Resource
	private OrderDetailMapper orderDetailMapper;
	@Resource
	private IUserService userService;
	@Resource
	private IBasicService basicService;
	@Resource
	private ICustomerService customerService;
	
	/**
	  *  新增订单需要查询的信息有
	 *   1、查询出所有的业务员
	 *   2、查询出所有的客户
	 *   3、查询基础数据
	  *   付款方式：BASIC_PAYMENT_TYPE
	  *   货运方式：BASIC_FREIGHT_TYPE
	  *   取件方式：BASIC_FETCH_TYPE
	  *   常用区间：BASIC_COMMON_INTERVAL
	  *   国家：Constant.BASIC_COMMON_INTERVAL
	  *   单位：Constant.BASIC_UNIT
	 */
	
	@Override
	public void getUpdateInfo(Integer id, Model model) {
		// 1.查询所有具有业务员角色的用户信息
		List<User> users = userService.queryUserByRoleName(Constant.ROLE_SALESMAN);
		// 2.查询 常用区间的基础数据
		List<BasicData> intervals = basicService.getBasicDataByParentName(Constant.BASIC_COMMON_INTERVAL);
		// 3.付款方式
		List<BasicData> payments = basicService.getBasicDataByParentName(Constant.BASIC_PAYMENT_TYPE);
		// 4.货运方式
		List<BasicData> freights = basicService.getBasicDataByParentName(Constant.BASIC_FREIGHT_TYPE);
		// 5.取件方式
		List<BasicData> fetchs = basicService.getBasicDataByParentName(Constant.BASIC_FETCH_TYPE);
		// 6.查询客户信息
		List<Customer> customers = customerService.query(null);
		// 7.国家
		List<BasicData> countrys = basicService.getBasicDataByParentName(Constant.BASIC_COMMON_INTERVAL);
		// 8.单位
		List<BasicData> units = basicService.getBasicDataByParentName(Constant.BASIC_UNIT);
		
		model.addAttribute("users", users);
		model.addAttribute("intervals", intervals);
		model.addAttribute("payments", payments);
		model.addAttribute("freights", freights);
		model.addAttribute("fetchs", fetchs);
		model.addAttribute("customers", customers);
		model.addAttribute("countrys", countrys);
		model.addAttribute("units", units);
	}

	@Override
	public void addOrder(OrderDto dto) {
		orderMapper.insertSelective(dto);
		//添加订单主表  获取生成的key
		List<OrderDetail> details = dto.getOrderDetails();
		if(details != null && details.size() > 0) {
			for(OrderDetail orderDetail : details) {
				//详情关联订单编号
				orderDetail.setOrderId(dto.getOrderId());
				//保存详情数据
				orderDetailMapper.insertSelective(orderDetail);
			}
		}
	}

}
