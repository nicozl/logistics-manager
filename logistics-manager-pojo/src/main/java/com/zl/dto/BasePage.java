package com.zl.dto;

/*
  *  封装分页的基本信息
 *
 * @version 2020年1月30日+下午1:47:11
 * @author zl
 */

public class BasePage {
	
	//当前页
	protected int pageNum = 1;
	
	//每页显示的条数
	protected int pageSize = 10;

	/**
	 * @return the pageNum
	 */
	public int getPageNum() {
		return pageNum;
	}

	/**
	 * @param pageNum the pageNum to set
	 */
	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	/**
	 * @return the pageSize
	 */
	public int getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
