package org.one.common.base;

import java.io.Serializable;

/** 
 * 基类
 * @see
 * @author  wangyao
 * @date	2018年4月30日 下午8:34:44
 * @version
 */
public class BaseEntity implements Serializable {
	
	private static final long serialVersionUID = 6684330035818165150L;
	
	private int page=1;
	
	private int limit=10;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}
}

		