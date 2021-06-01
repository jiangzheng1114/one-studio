		package org.one.common.config.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.alibaba.fastjson.JSON;

/** 
 * AOP的方式记录请求日志
 * @see
 * @author  wangyao
 * @date	2018年1月14日 下午5:45:10
 * @version
 * @desc    TODO
 */
@Aspect
@Component
public class HttpLogAspect {
	
	private final static Logger logger = LoggerFactory.getLogger(HttpLogAspect.class);
	
	ThreadLocal<Long> startTime = new ThreadLocal<Long>();
	
	@Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
	public void log() {
	}
	
	/**
	 * 在切入点前的操作，按order的值由小到大执行
	 * @Title: doBefore   
	 * @param joinPoint void
	 * @author wangy@woyitech.com
	 */
	@Before("log()")
	public void doBefore(JoinPoint joinPoint) {
		startTime.set(System.currentTimeMillis());
		
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();

		StringBuffer url = request.getRequestURL();  
		//URL
		logger.info("URL : {}", url);
		
		String tempContextUrl = url.delete(url.length() - request.getRequestURI().length(), url.length()).toString();  
		
		//baseUrl
		logger.info("baseUrl : {}", tempContextUrl);
		request.setAttribute("base", tempContextUrl);
		
		//method
		logger.info("HTTP_METHOD : {}", request.getMethod());
		
		//ip
		logger.info("IP : {}", request.getRemoteAddr());
		
		//类方法
		logger.info("CLASS_METHOD : {}", 
				joinPoint.getSignature().getDeclaringTypeName() + 
				"." + joinPoint.getSignature().getName());
		
		//参数
		Object[] objs = joinPoint.getArgs();
		logger.info("ARGS : {}", objs);
		
	}
	
	/**
	 * 在切入点后的操作，按order的值由大到小执行
	 * @Title: doAfterReturning   
	 * @param object void
	 * @author wangy@woyitech.com
	 */
	@AfterReturning(returning= "object", pointcut= "log()")
	public void doAfterReturning(Object object) {
		//处理完请求，返回内容
		logger.info("RESPONSE : {} ", object != null ? JSON.toJSONString(object) : "null");
		logger.info("SPEND TIME : {} ms" , (System.currentTimeMillis() - startTime.get()));
	}
	

}

		