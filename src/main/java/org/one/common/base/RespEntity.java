package org.one.common.base;

/** 
 *
 * @see
 * @author  wangyao
 * @date	2018年1月27日 下午7:24:11
 * @version
 */
public class RespEntity<T> {
	
	/**
	 * 请求状态
	 */
	private Integer httpCode;
	
	/**
	 * 返回数据
	 */
	private T data;
	
	/**
	 * 额外数据
	 */
	private Object extraData;

	/**
	 * 提示信息
	 */
	private String message;

	public Integer getHttpCode() {
		return httpCode;
	}

	public void setHttpCode(Integer httpCode) {
		this.httpCode = httpCode;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Object getExtraData() {
		return extraData;
	}

	public void setExtraData(Object extraData) {
		this.extraData = extraData;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}

		