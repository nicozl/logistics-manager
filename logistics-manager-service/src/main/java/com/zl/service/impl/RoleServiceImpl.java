package com.zl.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zl.mapper.RoleMapper;
import com.zl.pojo.Role;
import com.zl.pojo.RoleExample;
import com.zl.service.IRoleService;

/*
 * @version 2020年1月30日+上午8:37:13
 * @author zl
 *
 */

@Service
public class RoleServiceImpl implements IRoleService{

	@Resource
	private RoleMapper mapper;
	
	@Override
	public List<Role> query(Role role) {
		RoleExample example = new RoleExample();
		if(role != null && !"".equals(role.getRoleName()) && role.getRoleName() != null) {
			example.createCriteria().andRoleNameLike("%" + role.getRoleName() + "%");
		}
		return mapper.selectByExample(example);
	}

	@Override
	public void addRole(Role role) throws Exception {
		mapper.insertSelective(role);
	}

	@Override
	public void updateRole(Role role) throws Exception {
		mapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public void deleteRole(int id) throws Exception {
		mapper.deleteByPrimaryKey(id);
	}

}
