package org.one.system.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.one.common.base.LayPage;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.system.entity.OneDept;
import org.one.system.service.OneDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/web/dept")
public class DeptController {

	@Autowired
	private OneDeptService oneDeptService;
	
	@RequestMapping(value = "/list")
	@ResponseBody
	public LayPage<OneDept> list(HttpServletRequest request, OneDept oneDept){
		LayPage<OneDept> depts = oneDeptService.findDeptsByPage(oneDept);
		return depts;
	}
	
	@RequestMapping(value = "/all")
	@ResponseBody
	public RespEntity<List<OneDept>>  all(HttpServletRequest request){
		RespEntity<List<OneDept>> resp = new RespEntity<>();
		List<OneDept> depts = oneDeptService.getAllDepts();
		resp.setHttpCode(HttpCode.Success);
		resp.setData(depts);
		resp.setMessage("请求成功");
		return resp;
	}
	
	@RequestMapping(value = "/add", method=RequestMethod.POST)
	@ResponseBody
	public RespEntity<Long>  add(HttpServletRequest request, @RequestBody OneDept dept){
		RespEntity<Long> resp = new RespEntity<>();
		Long id = oneDeptService.addDept(dept);
		if(id != null) {
			resp.setHttpCode(HttpCode.Success);
			resp.setData(id);
			resp.setMessage("请求成功");
		}else {
			resp.setHttpCode(HttpCode.Error);
			resp.setMessage("请求失败");
		}
		return resp;
	}
	
}
