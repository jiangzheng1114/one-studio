
/** 
 * @单位名称：暂无公司
 * @Copyright (c) 2018 All Rights Reserved.
 * @系统名称：Victor
 * @工程名称：world-base
 * @文件名称: GlobalExceptionHandler.java
 * @类路径: com.world.system.config.exception
 */

		package org.one.common.config.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/** 
 * 为MyException异常创建对应的处理
 * @see
 * @author  wangyao
 * @date	2018年2月3日 上午11:02:49
 * @version
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/**
	 * runtime异常发生的时候JVM调用的是父类无参的构造器.
	 * 而SQLException和IOException异常发生的时候JVM调用的是父类有参的构造器.
	 * Ps: e.getMessage = null
	 * @Title: jsonErrorHandler   
	 * @param req
	 * @param e
	 * @author wangyao
	 */
	@ExceptionHandler(value = Exception.class)
    public String errorHandler(HttpServletRequest req, Exception e) {
		logger.error("服务器异常: ", e);
        return "redirect:/web/error";
    }
	
}

		