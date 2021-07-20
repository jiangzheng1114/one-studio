package org.one.system.controller.web;

import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.common.enums.UserType;
import org.one.system.entity.Menu;
import org.one.system.entity.Role;
import org.one.system.entity.User;
import org.one.system.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import xyz.icrab.common.model.Pageable;
import xyz.icrab.common.model.Pagination;
import xyz.icrab.common.model.Result;
import xyz.icrab.common.model.Status;
import xyz.icrab.common.model.enums.YesOrNo;
import xyz.icrab.common.util.KeyUtils;
import xyz.icrab.ums.util.consts.SessionKeys;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 后台功能菜单
 * @author 周广
 */
@RestController
@CrossOrigin
@RequestMapping("/menu")
public class MenuController {


    @Autowired
    private MenuService menuService;/*菜单接口*/

    @RequestMapping(value = "/page")
    @ResponseBody
    public RespEntity<PageInfo<Menu>> page(HttpServletRequest request, @RequestBody Menu menu){
        RespEntity<PageInfo<Menu>> resp = new RespEntity<>();
        try {
            PageInfo<Menu> menus = menuService.getPage(menu);
            resp.setHttpCode(HttpCode.Success);
            resp.setData(menus);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

   /* *//**
     * 新增菜单
     * @param menu
     * @return
     */
   /* @RequestMapping("/add")
    public Result<?> add(@RequestBody Menu menu){
        menu.setId(KeyUtils.getKey());
        if(StringUtils.isEmpty(menu.getParentId()) || menu.getParentId().equals("ROOT")){
            menu.setParentId("ROOT");
            menu.setFloor(1);
            int i = menuService.save(menu);
            return Result.ok();
        }else {
            Menu menu1 = menuService.get(menu.getParentId());
            if(menu1==null){
                return Result.of(Status.ClientError.UPGRADE_REQUIRED, "上一级找不到");
            }
            menu.setFloor(menu1.getFloor()+1);
            if (menu.getFloor()>=4){
                return Result.of(Status.ClientError.UPGRADE_REQUIRED, "层级最多为3");
            }
            menuService.save(menu);
            return Result.ok();
        }
    }*/

    @RequestMapping("/add")
    public Result<?> addOrUpdate(@RequestBody Menu menu) {
        menu.setId(KeyUtils.getKey());
        int i = menuService.save(menu);
        return Result.ok(i);
    }
    /**
     * 新增菜单
     * @param menu
     * @return
     */
    @RequestMapping("/addOrUpdate")
    public Result<?> add(@RequestBody Menu menu) {
        menu.setId(KeyUtils.getKey());
        if (StringUtils.isEmpty(menu.getParentId()) || menu.getParentId().equals("ROOT")) {
            menu.setParentId("ROOT");
            menu.setFloor(1);
            menuService.save(menu);
            return Result.ok();
        } else {
            Menu menu1 = menuService.get(menu.getParentId());
            if (menu1 == null) {
                return Result.of(Status.ClientError.UPGRADE_REQUIRED, "上一级找不到");
            }
            menu.setFloor(menu1.getFloor() + 1);
            if (menu.getFloor() >= 4) {
                return Result.of(Status.ClientError.UPGRADE_REQUIRED, "层级最多为3");
            }
            menuService.save(menu);
            return Result.ok();

        }
    }

    /**
     * 更新菜单
     * @param menu
     * @return
     */
    @RequestMapping("/update")
    public Result<?> update(@RequestBody Menu menu){
        if(StringUtils.isEmpty(menu.getId())){
            return Result.of(Status.ClientError.UPGRADE_REQUIRED, "参数有误请检查");
        }
        if(StringUtils.isEmpty(menu.getParentId()) || menu.getParentId().equals("ROOT")){
            menu.setParentId("ROOT");
            menu.setFloor(1);
            menuService.update(menu);
            return Result.ok();
        }else {
            Menu menu1 = menuService.get(menu.getParentId());
            if (menu1 == null) {
                return Result.of(Status.ClientError.UPGRADE_REQUIRED, "上一级找不到");
            }
            menu.setFloor(menu1.getFloor() + 1);
            if (menu.getFloor() >= 4) {
                return Result.of(Status.ClientError.UPGRADE_REQUIRED, "层级最多为3");
            }
            menuService.update(menu);
            return Result.ok();
        }
    }

    /**
     * 删除菜单
     * @param menu
     * @return
     */
    @RequestMapping("/delete")
    public Result<?> delete(@RequestBody Menu menu){
        if(StringUtils.isBlank(menu.getId())){
            return Result.of(Status.ClientError.UPGRADE_REQUIRED, "参数有误请检查");
        }
        menuService.deleteMenu(menu);
        return Result.ok();
    }

    /**
     * 启用禁用
     * @param menu
     * @return
     *//*
    @RequestMapping("/enableAndDisabled")
    public Result<?> enableAndDisabled(@RequestBody Menu menu){
        if(StringUtils.isBlank(menu.getId())){
            return Result.of(Status.ClientError.UPGRADE_REQUIRED, "参数有误请检查");
        }
        menuService.update(menu);
        return Result.ok();
    }
    *//**
     * 用户权限修改
     * @param menu
     * @return
     *//*
    @RequestMapping("/updateType")
    public Result<?> updateType(@RequestBody Menu menu){
        if(StringUtils.isBlank(menu.getId())){
            return Result.of(Status.ClientError.UPGRADE_REQUIRED, "参数有误请检查");
        }
        menuService.update(menu);
        return Result.ok();
    }
    *//**
     * 查询get
     * @param param
     * @return
     */
    @RequestMapping("/get")
    public Result<?> get(@RequestBody Map<String, Object> param){
        Menu menu=menuService.getOneInParent(param);
        if(StringUtils.isBlank((String)param.get("id"))){
            return Result.of(Status.ClientError.UPGRADE_REQUIRED, "关键查询不能为空，请重试");
        }
        return Result.ok(menu);
    }

//     默认获取全部  list

    @RequestMapping("/list")
    public Result<?> list(){
        List<Menu> list=menuService.getList();
        return Result.ok(list);
        /* if (loginUser.getType()== UserType.Super){
            return Result.ok(menuService.list(param));
        }else{
            param.put("userId",loginUser.getId());
            param.put("state", YesOrNo.YES.value());
            return Result.ok(menuService.getListByUserId(param));
        }
    */
    }
}
