package org.one.common.base;

import java.util.List;

import com.github.pagehelper.Page;

public class LayPage<E> {
	
	private Integer code;
	
	private String msg;
	
	private Long count;
	
	private Object[] data;
	
	public LayPage(Page<E> page) {
		List<E> list = page.getResult();
		this.code = 0;
		this.msg = "LayPage";
		this.count = page.getTotal();
		this.data = list.toArray();
	}

	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Object[] getData() {
		return data;
	}

	public void setData(Object[] data) {
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
