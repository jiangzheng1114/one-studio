package org.one.common.config.shiro;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.one.system.entity.OneUser;
import org.one.system.mapper.OneUserMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class MyShiroRealm extends AuthorizingRealm {

	private final static Logger logger = LoggerFactory.getLogger(MyShiroRealm.class);

	@Autowired
	private OneUserMapper oneUserMapper;

	/**
	 * 主要是用来进行身份认证的，也就是说验证用户输入的账号和密码是否正确
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		logger.info("MyShiroRealm.doGetAuthenticationInfo()");
		// 获取用户的输入的账号.
		String username = (String) token.getPrincipal();
		// 通过username从数据库中查找
		OneUser user = oneUserMapper.getByUsername(username);
		if (user == null) {
			return null;
		}
		if (user.getStatus() == OneUser.Status.Disabled.getCode()) {
			throw new LockedAccountException();
		}
		SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(user, // 用户名
				user.getPassword(), // 密码
				ByteSource.Util.bytes(user.getSalt()), getName() // realm name
		);

		return authenticationInfo;

	}

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;
	}

}