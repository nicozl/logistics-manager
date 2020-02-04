package com.zl.service;

import java.util.List;

import com.zl.pojo.Role;

/*
  * 角色
 * @version 2020年1月30日+上午8:32:18
 * @author zl
 *
 */

public interface IRoleService {
	
	/**
	  *  根据条件查询角色
	 * @param role
	 * @return
	 */
	public List<Role> query(Role role);
	
	/**
	  *  添加角色信息
	 * @param role
	 * @throws Exception
	 */
	public void addRole(Role role) throws Exception;
	
	/**
	  * 根据id更新角色信息
	 * @param role
	 * @throws Exception
	 */
	public void updateRole(Role role) throws Exception;
	
	/**
	  * 根据id 删除角色信息
	 * @param id
	 * @throws Exception
	 */
	public void deleteRole(int id) throws Exception;
}
