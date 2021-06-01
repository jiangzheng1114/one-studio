package org.one.common.base.code;

public class HttpCode {
	
	/**
	 * 请求成功
	 */
	public static final Integer Success = 200;

	/**
	 * 逻辑异常
	 */
	public static final Integer Warn = 203;
	
	/**
	 * 请求失败
	 */
	public static final Integer Error = 500;
	
	/**
	 * 需要授权（重新登录）
	 */
	public static final Integer Noauth = 401;
	
	/**
	 * 禁止访问
	 */
	public static final Integer Forbidden  = 403;
	
}
