
/** 
 * @单位名称：暂无公司
 * @Copyright (c) 2018 All Rights Reserved.
 * @系统名称：Victor
 * @工程名称：world-base
 * @文件名称: BaseController.java
 * @类路径: com.world.system.controller
 */

		package org.one.common.base;

import javax.servlet.ServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.one.system.entity.OneUser;
import org.one.system.service.OneUserService;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSON;

/** 
 *
 * @see
 * @author  wangyao
 * @date	2018年1月31日 下午10:25:05
 * @version
 */
public class BaseController {
	
	@Autowired
	private OneUserService oneUserService;
	
	public OneUser getUserByHeader(ServletRequest request) throws Exception{
		Session session = SecurityUtils.getSubject().getSession();
		Object obj = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
		SimplePrincipalCollection coll = (SimplePrincipalCollection) obj;
		String userStr = JSON.toJSON(coll.getPrimaryPrincipal()).toString();
		OneUser user = JSON.parseObject(userStr, OneUser.class);
        return oneUserService.getUserInfoById(user.getId());
	}
	
}

		