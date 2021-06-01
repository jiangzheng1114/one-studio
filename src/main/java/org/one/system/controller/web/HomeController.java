package org.one.system.controller.web;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.one.common.base.BaseController;
import org.one.common.base.RespEntity;
import org.one.common.base.code.ApplyCode;
import org.one.common.base.code.HttpCode;
import org.one.system.entity.OneUser;
import org.one.system.service.OneUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/** 
 * 登录登出等...
 * @see
 * @author  wangyao
 * @date	2018年7月29日 下午12:38:15
 * @version
 */
@Controller
@RequestMapping("/web")
public class HomeController extends BaseController{
	
	@Autowired
	private OneUserService oneUserService;
	
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	@ResponseBody
	public RespEntity<String> doLogin(HttpServletRequest request, @RequestBody OneUser user) throws Exception {
		RespEntity<String> result = new RespEntity<String>();
		try {
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
			subject.login(token);
			String authorization = (String) subject.getSession().getId();
			result.setHttpCode(HttpCode.Success);
			result.setData(authorization);
			result.setMessage("登陆成功");
		} catch (IncorrectCredentialsException e) {
			result.setExtraData("pwderror");
			result.setMessage("密码错误");
		} catch (LockedAccountException e) {
			result.setMessage("该用户已被禁用");
		} catch (AuthenticationException e) {
			result.setMessage("该用户不存在");
		}
		return result;
	}
	
	@RequestMapping(value = "/logout")
	@ResponseBody
	public RespEntity<String> logout(HttpServletRequest request) throws Exception {
		RespEntity<String> resp = new RespEntity<>();
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.logout();
		resp.setHttpCode(HttpCode.Success);
		resp.setMessage("注销成功");
		return resp;
	}
	
	@RequestMapping(value = "/unauth")
	@ResponseBody
	public RespEntity<String> unauth(HttpServletRequest request) throws Exception {
		RespEntity<String> resp = new RespEntity<>();
		resp.setHttpCode(HttpCode.Noauth);
		resp.setMessage("重新登录");
		return resp;
	}
	
	@RequestMapping(value = "/error")
	@ResponseBody
	public RespEntity<String> error(HttpServletRequest request) throws Exception {
		RespEntity<String> resp = new RespEntity<>();
		resp.setHttpCode(HttpCode.Error);
		resp.setMessage("服务器异常");
		return resp;
	}
	
	@RequestMapping(value = "/getUserInfo")
	@ResponseBody
	public RespEntity<OneUser> getUserInfo(HttpServletRequest request) throws Exception {
		RespEntity<OneUser> resp = new RespEntity<>();
		OneUser user = getUserByHeader(request);
		resp.setHttpCode(HttpCode.Success);
		resp.setData(user);
		resp.setMessage("请求成功");
		return resp;
	}
	
	@RequestMapping(value = "/editPwd")
	@ResponseBody
	public RespEntity<String> editPwd(HttpServletRequest request, @RequestBody OneUser user) throws Exception{
		RespEntity<String> result = new RespEntity<String>();
		OneUser oneuer = getUserByHeader(request);
		//校验旧密码
		String oldsalt = oneuer.getSalt();
		Object oldobj = new SimpleHash(ApplyCode.ALGORITHMNAME, user.getOldpwd(), ByteSource.Util.bytes(oldsalt),
				ApplyCode.ITERATIONS);
		if(!oldobj.toString().equals(oneuer.getPassword())) {
			result.setHttpCode(HttpCode.Error);
			result.setMessage("密码不正确");
		}else {
			//修改密码
			String newsalt = String.valueOf(System.currentTimeMillis());
			Object newobj = new SimpleHash(ApplyCode.ALGORITHMNAME, user.getNewpwd(), ByteSource.Util.bytes(newsalt),
					ApplyCode.ITERATIONS);
			oneuer.setPassword(newobj.toString());
			oneuer.setSalt(newsalt);
			oneUserService.editPassword(oneuer);
			result.setHttpCode(HttpCode.Success);
			result.setMessage("密码修改成功");
		}
		return result;
	}
}

		