package org.one.system.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.One;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.system.entity.OneMenu;
import org.one.system.entity.OneRole;
import org.one.system.service.OneRoleService;
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
@RequestMapping("/web/role")
public class OneRoleController {
	
	private final static Logger logger = LoggerFactory.getLogger(OneRoleController.class);

	@Autowired
	private OneRoleService oneRoleService;
	
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	@ResponseBody
	public RespEntity<Long> add(HttpServletRequest request, @RequestBody OneRole oneRole){
		RespEntity<Long> resp = new RespEntity<>();
		Long roleid = oneRoleService.addRole(oneRole);
		if(roleid != null) {
			resp.setHttpCode(HttpCode.Success);
			resp.setData(roleid);
			resp.setMessage("添加成功");
		}else {
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("添加失败");
		}
		return resp;
	}
	
	@RequestMapping(value = "/page")
	@ResponseBody
	public RespEntity<PageInfo<OneRole>> page(HttpServletRequest request, @RequestBody OneRole oneRole){
		RespEntity<PageInfo<OneRole>> resp = new RespEntity<>();
		try {
			PageInfo<OneRole> roles = oneRoleService.findRolesByPage(oneRole);
			resp.setHttpCode(HttpCode.Success);
			resp.setData(roles);
			resp.setMessage("请求成功");
		} catch (Exception e) {
			logger.error("RoleController.page:", e);
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("请求失败");
		}
		return resp;
	}
	
	@RequestMapping(value = "/all")
	@ResponseBody
	public RespEntity<List<OneRole>> all(HttpServletRequest request){
		RespEntity<List<OneRole>> resp = new RespEntity<>();
		OneRole oneRole = new OneRole();
		oneRole.setStatus(OneMenu.Status.Normal.getCode());
		List<OneRole> roles = oneRoleService.findRoleList(oneRole);
		resp.setHttpCode(HttpCode.Success);
		resp.setData(roles);
		resp.setMessage("请求成功");
		return resp;
	}
	
	@RequestMapping(value = "/check")
	@ResponseBody
	public RespEntity<Integer> checkAppid(HttpServletRequest request, @RequestParam(value="item") String item,
			@RequestParam(value="itemValue") String itemValue, @RequestParam(required=false) Long roleid) {
		RespEntity<Integer> resp = new RespEntity<>();
		Integer num = oneRoleService.checkExistByItem(item, itemValue, roleid);
		resp.setHttpCode(HttpCode.Success);
		resp.setData(num);
		return resp;
	}
	
	@RequestMapping(value = "/delete")
	@ResponseBody
	public RespEntity<Boolean> delete(HttpServletRequest request, @RequestParam String selections){
		RespEntity<Boolean> resp = new RespEntity<>();
		try {
			oneRoleService.deleteBySelections(selections);
			resp.setHttpCode(HttpCode.Success);
			resp.setData(true);
			resp.setMessage("请求成功");
		} catch (Exception e) {
			logger.error("RoleController.delete:", e);
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("请求失败");
		}
		return resp;
	}
	
	@RequestMapping(value = "/changeStatus", method=RequestMethod.POST)
	@ResponseBody
	public RespEntity<Boolean> changeStatus(HttpServletRequest request, @RequestBody OneRole oneRole){
		RespEntity<Boolean> resp = new RespEntity<>();
		try {
			oneRoleService.changeStatus(oneRole.getId());
			resp.setHttpCode(HttpCode.Success);
			resp.setData(true);
			resp.setMessage("请求成功");
		} catch (Exception e) {
			logger.error("RoleController.changeStatus:", e);
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
			OneRole role = oneRoleService.selectById(id);
			json.put("role", role);
			List<Long> rolemenus = oneRoleService.selectMenusByRoleid(id);
			json.put("rolemenus", rolemenus);
			resp.setHttpCode(HttpCode.Success);
			resp.setData(json);
			resp.setMessage("请求成功");
		} catch (Exception e) {
			logger.error("RoleController.detail:", e);
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("请求失败");
		}
		return resp;
	}
	
	@RequestMapping(value = "/edit", method=RequestMethod.POST)
	@ResponseBody
	public RespEntity<Boolean> edit(HttpServletRequest request, @RequestBody OneRole oneRole){
		RespEntity<Boolean> resp = new RespEntity<>();
		try {
			oneRoleService.editRole(oneRole);
			resp.setHttpCode(HttpCode.Success);
			resp.setData(true);
			resp.setMessage("请求成功");
		} catch (Exception e) {
			logger.error("RoleController.edit:", e);
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("请求失败");
		}
		return resp;
	}
}
