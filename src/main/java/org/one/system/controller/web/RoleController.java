package org.one.system.controller.web;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.system.entity.*;
import org.one.system.service.RoleMenuService;
import org.one.system.service.RoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.icrab.common.model.Result;
import xyz.icrab.common.model.Status;
import xyz.icrab.common.util.KeyUtils;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *后台用户角色
 * @author 周广
 */
@RestController

@CrossOrigin
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleMenuService roleMenuService;

    /**
     * 分页查询   超级管理员使用，   无限制查询
     * @return
     */
    @RequestMapping("/page")
    public RespEntity<PageInfo<Role>> getPage(HttpServletRequest request, @RequestBody Role role) {
        RespEntity<PageInfo<Role>> resp = new RespEntity<>();
        try {
            PageInfo<Role> roles = roleService.getPage(role);
            resp.setHttpCode(HttpCode.Success);
            resp.setData(roles);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }


    @RequestMapping("/addOrUpdate")
    public Result<?> addOrUpdate(@RequestBody Role role){
        if(StringUtils.isBlank(role.getId())){
            Map<String,Object> map=new HashMap<>();
            map.put("name",role.getName());
            List<Role> roleList=roleService.findByRoleName(map);
            if(roleList.size()==0){
                role.setId(KeyUtils.getKey());
                roleService.save(role);
            }else{
                return Result.of(Status.ClientError.UPGRADE_REQUIRED, "该角色名已存在"+roleList.get(0).getName());
            }
        }else{
            roleService.editRole(role);
        }
        return Result.ok();
    }


    @RequestMapping(value = "/delete")
    @ResponseBody
    public RespEntity<Boolean> delete(HttpServletRequest request, @RequestParam String selections){
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            roleService.deleteBySelections(selections);
            resp.setHttpCode(HttpCode.Success);
            resp.setData(true);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

}
