package com.zl.service;

import java.util.List;

import org.springframework.ui.Model;

import com.github.pagehelper.PageInfo;
import com.zl.dto.BasicDataDto;
import com.zl.pojo.BasicData;

/*
 * 
 *
 * @version 2020年1月31日+上午8:13:05
 * @author zl
 */

public interface IBasicService {
	
	public List<BasicData> query(BasicData bd);
	
	public PageInfo<BasicData> queryPage(BasicDataDto dto);
	
	public void addBasicData(BasicData bd);
	
	public void deleteBasicData(int id);
	
	public void updateBasicData(BasicData bd);
	
	public void getUpdateInfo(Integer id, Model m);
	
	/**
	  *  根据大类名称查询对应的小类
	 * @param parentName
	 * @return
	 */
	public List<BasicData> getBasicDataByParentName(String parentName);
}
