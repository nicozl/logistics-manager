package com.zl.dto;

import java.util.List;

import com.zl.pojo.User;

/*
 * User传输对象
 *
 * @version 2020年1月30日+上午11:28:47
 * @author zl
 */

public class UserDto extends BasePage{
	//用户信息
	public User user;
	
	//关联分配的角色信息
	public List<Integer> roles;

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

	/**
	 * @return the roles
	 */
	public List<Integer> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(List<Integer> roles) {
		this.roles = roles;
	}

}
