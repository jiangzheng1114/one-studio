package org.one.common.util;

import java.util.List;

public class PageResult {

	private Integer currPage;
	
	private Integer pageSize;
	
	private Integer total;
	
	private List<?> list;
	
	public PageResult() {
		
	}

	public PageResult(Integer currPage, Integer pageSize, Integer total, List<?> list) {
		super();
		this.currPage = currPage;
		this.pageSize = pageSize;
		this.total = total;
		this.list = list;
	}

	public Integer getCurrPage() {
		return currPage;
	}

	public void setCurrPage(Integer currPage) {
		this.currPage = currPage;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public List<?> getList() {
		return list;
	}

	public void setList(List<?> list) {
		this.list = list;
	}
	
}
