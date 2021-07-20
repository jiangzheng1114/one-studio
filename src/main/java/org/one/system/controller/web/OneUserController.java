package org.one.system.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.One;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.system.entity.OneUser;
import org.one.system.service.OneUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/web/user")
public class OneUserController {
	
	private final static Logger logger = LoggerFactory.getLogger(OneUserController.class);
	
	@Autowired
	private OneUserService oneUserService;
	
	@RequestMapping(value = "/page")
	@ResponseBody
	public RespEntity<PageInfo<OneUser>> page(HttpServletRequest request, @RequestBody OneUser oneUser){
		RespEntity<PageInfo<OneUser>> resp = new RespEntity<>();
		try {
			PageInfo<OneUser> users = oneUserService.findUsersByPage(oneUser);
			resp.setHttpCode(HttpCode.Success);
			resp.setData(users);
			resp.setMessage("请求成功");
		} catch (Exception e) {
			logger.error("UserController.page:", e);
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("请求失败");
		}
		return resp;
	}
	
	@RequestMapping(value = "/detail")
	@ResponseBody
	public RespEntity<JSONObject> detail(HttpServletRequest request, Long id){
		RespEntity<JSONObject> resp = new RespEntity<>();
		JSONObject json = new JSONObject();
		try {
			OneUser user = oneUserService.getUserInfoById(id);
			json.put("user", user);
			List<Long> userroles = oneUserService.selectRolesByUserid(id);
			json.put("userroles", userroles);
			resp.setHttpCode(HttpCode.Success);
			resp.setData(json);
			resp.setMessage("请求成功");
		} catch (Exception e) {
			logger.error("UserController.detail:", e);
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("请求失败");
		}
		return resp;
	}
	
	@RequestMapping(value = "/edit", method=RequestMethod.POST)
	@ResponseBody
	public RespEntity<Boolean> edit(HttpServletRequest request, @RequestBody OneUser oneUser){
		RespEntity<Boolean> resp = new RespEntity<>();
		try {
			oneUserService.editUser(oneUser);
			resp.setHttpCode(HttpCode.Success);
			resp.setData(true);
			resp.setMessage("请求成功");
		} catch (Exception e) {
			logger.error("UserController.edit:", e);
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("请求失败");
		}
		return resp;
	}
	
	@RequestMapping(value = "/changeStatus", method=RequestMethod.POST)
	@ResponseBody
	public RespEntity<Boolean> changeStatus(HttpServletRequest request, @RequestBody OneUser oneUser){
		RespEntity<Boolean> resp = new RespEntity<>();
		try {
			oneUserService.changeStatus(oneUser.getId());
			resp.setHttpCode(HttpCode.Success);
			resp.setData(true);
			resp.setMessage("请求成功");
		} catch (Exception e) {
			logger.error("UserController.changeStatus:", e);
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("请求失败");
		}
		return resp;
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public RespEntity<Boolean> delete(HttpServletRequest request, @RequestParam String selections){
		RespEntity<Boolean> resp = new RespEntity<>();
		try {
			oneUserService.deleteBySelections(selections);
			resp.setHttpCode(HttpCode.Success);
			resp.setData(true);
			resp.setMessage("请求成功");
		} catch (Exception e) {
			logger.error("UserController.delete:", e);
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("请求失败");
		}
		return resp;
	}
	
	@RequestMapping(value = "/allEmployees")
	@ResponseBody
	public RespEntity<List<OneUser>>  all(HttpServletRequest request, OneUser oneUser){
		RespEntity<List<OneUser>> resp = new RespEntity<>();
		oneUser.setStatus(OneUser.Status.Normal.getCode());
		oneUser.setType(OneUser.Type.Employee.getCode());
		List<OneUser> users = oneUserService.getAllUsers(oneUser);
		resp.setHttpCode(HttpCode.Success);
		resp.setData(users);
		resp.setMessage("请求成功");
		return resp;
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	@ResponseBody
	public RespEntity<Long> add(HttpServletRequest request, @RequestBody OneUser oneUser){
		RespEntity<Long> resp = new RespEntity<>();
		Long userid = oneUserService.addUser(oneUser);
		if(userid != null) {
			resp.setHttpCode(HttpCode.Success);
			resp.setData(userid);
			resp.setMessage("添加成功");
		}else {
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("添加失败");
		}
		return resp;
	}
	
	@RequestMapping(value = "/check")
	@ResponseBody
	public RespEntity<Integer> checkAppid(HttpServletRequest request, @RequestParam(value="item") String item,
			@RequestParam(value="itemValue") String itemValue, @RequestParam(required=false) Long userid) {
		RespEntity<Integer> resp = new RespEntity<>();
		Integer num = oneUserService.checkExistByItem(item, itemValue, userid);
		resp.setHttpCode(HttpCode.Success);
		resp.setData(num);
		return resp;
	}

}
