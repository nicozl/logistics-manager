package com.zl.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.zl.dto.BasicDataDto;
import com.zl.pojo.BasicData;
import com.zl.service.IBasicService;

/*
 * 
 *
 * @version 2020年1月31日+上午8:25:49
 * @author zl
 */

@Controller
@RequestMapping("/basic")
public class BasicDataController {

	@Resource
	private IBasicService basicService;
	
	@RequestMapping("/query")
	public String queryPage(BasicDataDto dto,Model model){
		PageInfo<BasicData> pageInfo = basicService.queryPage(dto);
		model.addAttribute("pageModel", pageInfo);
		return "basic/basic";
	}
	
	@RequestMapping("/basicUpdate")
	public String basicUpdate(Integer id,Model m){
		basicService.getUpdateInfo(id,m);
		return "basic/basicUpdate";
	}
	
	@RequestMapping("/saveOrUpdate")
	public String saveOrUpdate(BasicData bd){
		if(bd.getParentId() == 0){
			bd.setParentId(null);
		}
		if(bd.getBaseId() != null && bd.getBaseId() > 0){
			// 更新数据
			basicService.updateBasicData(bd);
		}else{
			// 添加数据
			basicService.addBasicData(bd);
		}
		return "redirect:/basic/query";
	}
	
	@RequestMapping("/delete")
	public String delete(Integer id){
		basicService.deleteBasicData(id);
		return "redirect:/basic/query";
	}
}
