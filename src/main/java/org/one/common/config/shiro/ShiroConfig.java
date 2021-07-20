package org.one.common.config.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.one.common.base.code.ApplyCode;
import org.one.common.base.code.ConfigCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ShiroConfig {

	private final static Logger logger = LoggerFactory.getLogger(ShiroConfig.class);
	
	@Resource
	private ConfigCode configCode;

	@Bean
	public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
		logger.info("ShiroConfiguration.shirFilter()");
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		//拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();
        filterChainDefinitionMap.put("/web/logout", "anon");
        filterChainDefinitionMap.put("/web/login", "anon");
		filterChainDefinitionMap.put("/energy/**", "anon");
		filterChainDefinitionMap.put("/app/**", "anon");
		filterChainDefinitionMap.put("/web/**", "authc");
		filterChainDefinitionMap.put("/web/file/**", "anon");
        shiroFilterFactoryBean.setLoginUrl("/web/unauth");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
	}

	/**
	 * 凭证匹配器 （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了 ）
	 * @return
	 */
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName(ApplyCode.ALGORITHMNAME);
		hashedCredentialsMatcher.setHashIterations(ApplyCode.ITERATIONS);
		return hashedCredentialsMatcher;
	}

	/**
	 * 自定义的认证类
	 * @Title: myShiroRealm
	 * @Description: ShiroRealm，这是个自定义的认证类，继承自AuthorizingRealm，负责用户的认证和权限的处理
	 * @return MyShiroRealm
	 */
	@Bean
	public MyShiroRealm myShiroRealm() {
		MyShiroRealm myShiroRealm = new MyShiroRealm();
		myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return myShiroRealm;
	}
	
	/**
	 * 自定义sessionManager
	 */
	@Bean
	public SessionManager sessionManager() {
		MySessionManager mySessionManager = new MySessionManager();
		return mySessionManager;
	}

	/**
	 * 权限管理
	 * @Title: securityManager
	 * @Description: SecurityManager，权限管理，这个类组合了登陆，登出，权限，session的处理
	 * @return SecurityManager
	 */
	@Bean
	public SecurityManager securityManager() {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm());
		securityManager.setSessionManager(sessionManager());
		return securityManager;
	}
}
