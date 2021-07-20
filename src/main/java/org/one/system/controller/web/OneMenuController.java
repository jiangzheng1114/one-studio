package org.one.system.controller.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.annotations.One;
import org.one.common.base.BaseController;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.system.entity.OneMenu;
import org.one.system.entity.OneRole;
import org.one.system.entity.OneUser;
import org.one.system.service.OneMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/web/menu")
public class OneMenuController extends BaseController{
	
	private final static Logger logger = LoggerFactory.getLogger(OneRoleController.class);
	
	@Autowired
	private OneMenuService oneMenuService;
	
	@RequestMapping(value = "/page")
	@ResponseBody
	public RespEntity<PageInfo<OneMenu>> page(HttpServletRequest request, @RequestBody OneMenu oneMenu){
		RespEntity<PageInfo<OneMenu>> resp = new RespEntity<>();
		try {
			PageInfo<OneMenu> menus = oneMenuService.findMenusByPage(oneMenu);
			resp.setHttpCode(HttpCode.Success);
			resp.setData(menus);
			resp.setMessage("请求成功");
		} catch (Exception e) {
			logger.error("MenuController.page:", e);
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("请求失败");
		}
		return resp;
	}
	
	@RequestMapping(value = "/allFirst")
	@ResponseBody
	public RespEntity<List<OneMenu>> allFirst(HttpServletRequest request){
		RespEntity<List<OneMenu>> resp = new RespEntity<>();
		OneMenu oneMenu = new OneMenu();
		oneMenu.setStatus(OneMenu.Status.Normal.getCode());
		oneMenu.setLevel(OneMenu.Level.Frist.getCode());
		List<OneMenu> menus = oneMenuService.findMenuList(oneMenu);
		resp.setHttpCode(HttpCode.Success);
		resp.setData(menus);
		resp.setMessage("请求成功");
		return resp;
	}
	
	@RequestMapping(value = "/all")
	@ResponseBody
	public RespEntity<List<OneMenu>> all(HttpServletRequest request){
		RespEntity<List<OneMenu>> resp = new RespEntity<>();
		OneMenu oneMenu = new OneMenu();
		oneMenu.setStatus(OneMenu.Status.Normal.getCode());
		List<OneMenu> menus = oneMenuService.findMenuList(oneMenu);
		resp.setHttpCode(HttpCode.Success);
		resp.setData(menus);
		resp.setMessage("请求成功");
		return resp;
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	@ResponseBody
	public RespEntity<Long> add(HttpServletRequest request, @RequestBody OneMenu oneMenu){
		RespEntity<Long> resp = new RespEntity<>(); 
		Long menuid = oneMenuService.addMenu(oneMenu);
		if(menuid != null) {
			resp.setHttpCode(HttpCode.Success);
			resp.setData(menuid);
			resp.setMessage("添加成功");
		}else {
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("添加失败");
		}
		return resp;
	}
	
	@RequestMapping(value = "/one", method=RequestMethod.GET)
	@ResponseBody
	public RespEntity<OneMenu> one(HttpServletRequest request, Long menuid){
		RespEntity<OneMenu> resp = new RespEntity<>();
		try {
			OneMenu menu = oneMenuService.findMenuById(menuid);
			resp.setHttpCode(HttpCode.Success);
			resp.setData(menu);
			resp.setMessage("请求成功");
		} catch (Exception e) {
			logger.error("MenuController.one:", e);
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("请求失败");
		}
		return resp;
	}
	
	@RequestMapping(value = "/edit", method=RequestMethod.POST)
	@ResponseBody
	public RespEntity<Boolean> edit(HttpServletRequest request, @RequestBody OneMenu oneMenu){
		RespEntity<Boolean> resp = new RespEntity<>();
		try {
			oneMenuService.editRole(oneMenu);
			resp.setHttpCode(HttpCode.Success);
			resp.setData(true);
			resp.setMessage("请求成功");
		} catch (Exception e) {
			logger.error("MenuController.edit:", e);
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("请求失败");
		}
		return resp;
	}
	
	JSONArray menusToJson(List<OneMenu> menus) {
		JSONArray jsonArray = new JSONArray();
		for(int i=0;i<menus.size();i++) {
			OneMenu menu = menus.get(i);
			JSONObject menuJson = (JSONObject) JSON.toJSON(menu);
			if(menu.getParentid() == null) {
				List<OneMenu> children = new ArrayList<>();
				for(int j=0;j<menus.size();j++) {
					if(menus.get(j).getParentid() != null && menus.get(j).getParentid() == menu.getId()) {
						children.add(menus.get(j));
					}
				}
				menuJson.put("children", children);
				jsonArray.add(menuJson);
			}
		}
		return jsonArray;
	}

	@RequestMapping(value = "/usermenus", method=RequestMethod.GET)
	@ResponseBody
	public RespEntity<List<OneMenu>> usermenus(HttpServletRequest request){
		RespEntity<List<OneMenu>> resp = new RespEntity<>();
		try {
			List<OneMenu> menus;
			OneUser currentUser = getUserByHeader(request);
			if(OneUser.Type.Employee.getCode() == currentUser.getType()) {
				menus = oneMenuService.findMenusByUserid(currentUser.getId());
			}else {
				OneMenu oneMenu = new OneMenu();
				oneMenu.setStatus(OneMenu.Status.Normal.getCode());
				menus =  oneMenuService.findMenuList(oneMenu);
			}
			resp.setHttpCode(HttpCode.Success);
			resp.setData(menus);
			resp.setMessage("请求成功");
		} catch (Exception e) {
			logger.error("MenuController.usermenus:", e);
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("请求失败");
		}
		return resp;
	}
	
	@RequestMapping(value = "/check")
	@ResponseBody
	public RespEntity<Integer> checkAppid(HttpServletRequest request, @RequestParam(value="item") String item,
			@RequestParam(value="itemValue") String itemValue, @RequestParam(required=false) Long menuid) {
		RespEntity<Integer> resp = new RespEntity<>();
		Integer num = oneMenuService.checkExistByItem(item, itemValue, menuid);
		resp.setHttpCode(HttpCode.Success);
		resp.setData(num);
		return resp;
	}
}
