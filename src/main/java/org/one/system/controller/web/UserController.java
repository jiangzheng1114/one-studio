package org.one.system.controller.web;

import ch.qos.logback.core.joran.util.StringToObjectConverter;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
import org.apache.commons.lang.StringUtils;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.common.enums.UserType;
import org.one.energy.common.HttpsUtil;
import org.one.system.entity.Menu;
import org.one.system.entity.Role;
import org.one.system.entity.User;
import org.one.system.entity.UserRole;
import org.one.system.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import xyz.icrab.common.model.Pageable;
import xyz.icrab.common.model.Pagination;
import xyz.icrab.common.model.Result;
import xyz.icrab.common.model.Status;
import xyz.icrab.common.model.enums.YesOrNo;
import xyz.icrab.common.util.KeyUtils;
import xyz.icrab.common.web.annotation.EnableListRequest;
import xyz.icrab.common.web.annotation.PermissionMode;
import xyz.icrab.common.web.consts.HeaderNames;
import xyz.icrab.common.web.util.Validator;
import xyz.icrab.ums.util.consts.SessionKeys;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.*;


/**
 * 后台管理人员   用户
 * @auther  周广
 */

@CrossOrigin
@RestController
@RequestMapping("/user")
@EnableListRequest
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private MenuService menuService;
    @Resource
    private UserRoleService userRoleService;
    @Resource
    private RoleService roleService;


    /**
     * 分页查询
     */
    @RequestMapping("/page")
    @PermissionMode(PermissionMode.Mode.White)
    public RespEntity<PageInfo<User>> getPage(HttpServletRequest request, @RequestBody User user){
        RespEntity<PageInfo<User>> resp = new RespEntity<>();
        try {
            PageInfo<User> users = userService.getPage(user);
            resp.setHttpCode(HttpCode.Success);
            resp.setData(users);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    /**
     * 登录接口，缓存信息
     * @param param
     * @param request
     * @param response
     * @return
     */
    @RequestMapping("/login")
    @PermissionMode(PermissionMode.Mode.White)
    public Result<?> login(@RequestBody Map<String, Object> param, HttpServletRequest request , HttpServletResponse response,HttpSession session){

        //获取IP地址
        String ipAddress = getIpAddress(request);
        Map<String ,Object>  haha=new HashMap<>(2);
        haha.put("appid",ipAddress);

        Validator validator = new Validator();
        validator.notNull((String)param.get("username"), "请输入用户名");
        validator.notNull((String)param.get("password"), "请输入密码");
        if(validator.isError()) {
            return Result.of(Status.ClientError.BAD_REQUEST, validator.getMessage());
        }
        Map<String,Object> map=new HashMap<>();
        map.put("username",(String)param.get("username"));
        User user =userService.getUser(map);
        if(user==null){
            return Result.of(Status.ClientError.UPGRADE_REQUIRED, "未找到"+(String)param.get("username")+"用户");
        }
        if(!user.getPassword().equals(((String)param.get("password")))){
            return Result.of(Status.ClientError.UPGRADE_REQUIRED, "密码输入错误，请检查！");
        }

/*        Map<String,Object> params = new HashMap<>();
        params.put("userId",user.getId());
        List<Menu> menuList = listToTree(menuService.getListByUserId(params));*/

        Object id = user.getId();
        String token = KeyUtils.getKey();
        session.setAttribute("user",user);
/*        Map<String,Object> map1=new HashMap<>();
        map1.put("userId",user.getId());
        Role role = roleService.getRoleByUserId(map1);
        putToSession(user,menuList,token, role,response);*/
        return  Result.ok(token);
    }

    /**
     * 使用递归方法建树
     * @param menuList
     * @return
     */
    public static List<Menu> listToTree(List<Menu> menuList) {
        List<Menu> treeList = new ArrayList<Menu>();
        for (Menu menu: menuList) {
            if ("ROOT".equals(menu.getParentId())) {
                treeList.add(findChildren(menu,menuList));
            }
            treeList.add(findChildren(menu,menuList));
        }
        return treeList;
    }
    /**
     * 从HTTP请求中获取客户IP地址
     *
     * @param request http请求
     * @return 客户IP地址
     */
    public  String getIpAddress( HttpServletRequest request )
    {
        String ip = request.getHeader( "x-forwarded-for" );
        if ( ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase( ip ) )
        {
            ip = request.getHeader( "Proxy-Client-IP" );
        }
        if ( ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase( ip ) )
        {
            ip = request.getHeader( "WL-Proxy-Client-IP" );
        }
        if ( ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase( ip ) )
        {
            ip = request.getRemoteAddr();
        }
        return ip;
    }


    /**
     * 递归找子节点
     * @param menu
     * @param menuList
     * @return
     */
    public static Menu findChildren(Menu menu,List<Menu> menuList) {
        for (Menu it: menuList) {
            if(menu.getId().equals(it.getParentId())) {
                if (menu.getChildren() == null) {
                    menu.setChildren(new ArrayList<Menu>());
                }
                menu.getChildren().add(findChildren(it,menuList));
            }
        }
        return menu;
    }
    /**
     * 存入  session
     * @param user
     * @param token
     * @param res
     */
/*    private void putToSession(User user, List<Menu> menuList, String token, Role roles, HttpServletResponse res) {
        Session session = new DefaultSession(token);
        session.setAttribute(SessionKeys.USER, user);//存用户基本信息
        //查询菜单信息
        session.setAttribute(SessionKeys.ROLES,roles);
        session.setAttribute(SessionKeys.MENUS,menuList);
        session.setAttribute(SessionKeys.ROLES,roles);
        sessionService.set(session);
        res.setHeader(HeaderNames.TOKEN, token);
        //cookie
        Cookie cookie = new Cookie(HeaderNames.TOKEN, token);
        cookie.setPath("/");
        res.addCookie(cookie);
    }*/
    /**
     * 存入  session
     * @param user
     * @param token
     * @param res
     */
   /* private void putToSession2(User user,Role roles, String token, HttpServletResponse res) {
        Session session = new DefaultSession(token);
        session.setAttribute(SessionKeys.USER, user);//存用户基本信息
        //查询菜单信息
        session.setAttribute(SessionKeys.ROLES,roles);
//        sessionService.set(session);
        res.setHeader(HeaderNames.TOKEN, token);
        //cookie
        Cookie cookie = new Cookie(HeaderNames.TOKEN, token);
        cookie.setPath("/");
        res.addCookie(cookie);
    }*/

    /**
     * 获取个人用户信息
     * @param
     * @return
     */
    @RequestMapping("/getMe")
    public Result<?> getMe(HttpServletRequest request,HttpSession session) {
        User loginUser = (User)session.getAttribute("user");
        return Result.ok(loginUser);
    }

    /**
     * 获取个人菜单信息
     * @param
     * @return
     */
    @RequestMapping("/getMenu")
    public Result<?> getMenu(HttpServletRequest request,HttpSession session) {
        User user = (User)session.getAttribute("user");
        Map<String,Object> params = new HashMap<>();
        params.put("userId",user.getId());
        List<Menu> menuList = menuService.getListByUserId(params);
        return Result.ok(menuList);
    }

  /*  *//**
     * 新增用户
     * @param loginUser
     * @param user
     * @return
     *//*
    @RequestMapping("/addOrUpdate")
    public Result<?> add(@xyz.icrab.common.web.annotation.Session(SessionKeys.USER) User loginUser,@RequestBody User user){
        if(StringUtils.isBlank(user.getId())){
            user.setId(user.getMobile());
            Map<String,Object> searchMap=new HashMap<>();
            if(StringUtils.isBlank(user.getUsername())){
                return Result.of(Status.ClientError.UPGRADE_REQUIRED, "手机号不能为空");
            }
            searchMap.put("username",user.getUsername());
            Map<String,Object> search=new HashMap<>();
            search.put("nickname",user.getNickname());
            List<User> userList=userService.list(searchMap);
            List<User> userList2=userService.list(search);
            if(userList.size()==0){
                if (userList2.size()==0){
                    userService.save(user);
                }else{
                    return Result.of(Status.ClientError.UPGRADE_REQUIRED, "该用户昵称已存在"+userList2.get(0).getNickname());
                }

            }else{
                return Result.of(Status.ClientError.UPGRADE_REQUIRED, "该手机号已存在"+userList.get(0).getUsername());
            }
        }else{
            if(user.getId().equals(user.getMobile())){
                userService.update(user);
            }else{
                User user1=new User();
                user1.setId(user.getId());
                userService.delete(user1);
                user.setId(user.getMobile());
                userService.save(user);
            }

        }
        List<UserRole> userRoleList=user.getUserRoleList();
        if(userRoleList.size()!=0){
            for(UserRole userRole: userRoleList){
                userRole.setId(user.getId());
                userRole.setUserId(user.getId());
            }
            UserRole userRole=new UserRole();
            userRole.setUserId(user.getId());
            userRoleService.delete(userRole);
            userRoleService.save(userRoleList);
        }
        return Result.ok();
    }*/
    /**
     * 更新用户
     * @param loginUser
     * @param user
     * @return
     */
/*
    @RequestMapping("/update")
    public Result<?> update(@xyz.icrab.common.web.annotation.Session(SessionKeys.USER) User loginUser,@RequestBody User user){
        if(StringUtils.isBlank(user.getId())){
            return Result.of(Status.ClientError.UPGRADE_REQUIRED, "参数有误请检查");
        }
        userService.update(user);
        return Result.ok();
    }
*/

    /**
     * 删除用户
     * @param loginUser
     * @param user
     * @return
             */
/*    @RequestMapping("/delete")
    public Result<?> delete(@xyz.icrab.common.web.annotation.Session(SessionKeys.USER) User loginUser,@RequestBody User user){
        if(StringUtils.isBlank(user.getId())){
            return Result.of(Status.ClientError.UPGRADE_REQUIRED, "id必传，请检查！");
        }
        userService.delete(user);
        return Result.ok();
    }*/

    /**
     * 启用禁用
     * @param loginUser
     * @param user
     * @return
     */
/*    @RequestMapping("/enableAndDisabled")
    public Result<?> enableAndDisabled(@xyz.icrab.common.web.annotation.Session(SessionKeys.USER) User loginUser,@RequestBody User user){
        if(StringUtils.isBlank(user.getId())){
            return Result.of(Status.ClientError.UPGRADE_REQUIRED, "参数有误请检查");
        }
        userService.update(user);
        return Result.ok();
    }*/
    /**
     * 用户权限修改
     * @param loginUser
     * @param user
     * @return
     */
/*
    @RequestMapping("/updateType")
    public Result<?> updateType(@xyz.icrab.common.web.annotation.Session(SessionKeys.USER) User loginUser,@RequestBody User user){
        if(StringUtils.isBlank(user.getId())){
            return Result.of(Status.ClientError.UPGRADE_REQUIRED, "参数有误请检查");
        }
        userService.update(user);
        return Result.ok();
    }
*/

    /**
     * 重置密码
     * @param loginUser
     * @param user
     * @return
     */
/*    @RequestMapping("/resetPassword")
    public Result<?> resetPassword(@xyz.icrab.common.web.annotation.Session(SessionKeys.USER) User loginUser,@RequestBody User user){
        if(StringUtils.isBlank(user.getId())){
            return Result.of(Status.ClientError.UPGRADE_REQUIRED, "参数有误请检查");
        }
        user.setPassword("123456");
        userService.update(user);
        return Result.ok();
    }*/
/*
    */
/**
     * 查询单个信息
     * @param loginUser
     * @param user
     * @return
     *//*

    @RequestMapping("/get")
    public Result<?> get(@xyz.icrab.common.web.annotation.Session(SessionKeys.USER) User loginUser,@RequestBody User user){
        if(StringUtils.isBlank(user.getId())){
            return Result.of(Status.ClientError.UPGRADE_REQUIRED, "参数有误请检查");
        }
        User user1=userService.getOneAndRole(user);
        return Result.ok(user1);
    }

    */
/**
     * 批量删除
     *//*

    @RequestMapping("/deleteAll")
    @PermissionMode(PermissionMode.Mode.White)
    public Result<?> deleteAll(@RequestBody @Valid IdsParam idsParam){
        List<String> ids = idsParam.getIds();
        userService.delete(ids);
        userRoleService.delete(ids);
        return Result.ok();
    }
*/

   /* *//**
     *后台用户导出
     * @param req
     * @param resp
     * @throws IOException
     *//*
    @RequestMapping("/export")
    @PermissionMode(PermissionMode.Mode.White)
    public void exportCategory(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
//        map.put("roleCode","zhiyeguwen");
        List<UserExo> list = userService.listExo(map);
        // 导出Excel when every body look at this ,be care this boss is sha bi
        OutputStream os = resp.getOutputStream();
        resp.setContentType("application/x-download");
        // 设置导出文件名称
        resp.setHeader("Content-Disposition",
                "attachment;filename=" + DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS") + ".xlsx");
        ExportParams param = new ExportParams("后台用户信息", "修改手机号只能在后台完成", "后台用户信息");
        param.setType(ExcelType.XSSF);
        Workbook excel = ExcelExportUtil.exportExcel(param, UserExo.class, list);
        excel.write(os);
        os.flush();
        os.close();
    }
    @RequestMapping("/exportzy")
    @PermissionMode(PermissionMode.Mode.White)
    public void exportzy(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        HashMap<String, Object> map = new HashMap<>();
        map.put("roleCode","zhiyeguwen");
        List<UserExozy> list = userService.listExozy(map);
        // 导出Excel
        OutputStream os = resp.getOutputStream();
        resp.setContentType("application/x-download");
        // 设置导出文件名称 jie  up if you do not believe me please
        resp.setHeader("Content-Disposition",
                "attachment;filename=" + DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS") + ".xlsx");
        ExportParams param = new ExportParams("后台用户信息", "修改手机号只能在后台完成", "后台用户信息");
        param.setType(ExcelType.XSSF);
        Workbook excel = ExcelExportUtil.exportExcel(param, UserExozy.class, list);
        excel.write(os);
        os.flush();
        os.close();
    }
    *//**
     *模板下载
     * @param req
     * @param resp
     * @throws IOException
     *//*
    @RequestMapping("/exportModel")
    @PermissionMode(PermissionMode.Mode.White)
    public void exportModel(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<UserExo> list = new ArrayList<>();
        // 导出Excel
        OutputStream os = resp.getOutputStream();
        resp.setContentType("application/x-download");
        // 设置导出文件名称
        resp.setHeader("Content-Disposition",
                "attachment;filename=" + DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS") + ".xlsx");
        ExportParams param = new ExportParams("后台用户信息", "修改手机号只能在后台完成", "后台用户信息");
        param.setType(ExcelType.XSSF);
        Workbook excel = ExcelExportUtil.exportExcel(param, UserExo.class, list);
        excel.write(os);
        os.flush();
        os.close();
    }
    @RequestMapping("/exportModelzy")
    @PermissionMode(PermissionMode.Mode.White)
    public void exportModelzy(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<UserExozy> list = new ArrayList<>();
        // 导出Excel
        OutputStream os = resp.getOutputStream();
        resp.setContentType("application/x-download");
        // 设置导出文件名称
        resp.setHeader("Content-Disposition",
                "attachment;filename=" + DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS") + ".xlsx");
        ExportParams param = new ExportParams("后台用户信息", "修改手机号只能在后台完成", "后台用户信息");
        param.setType(ExcelType.XSSF);
        Workbook excel = ExcelExportUtil.exportExcel(param, UserExozy.class, list);
        excel.write(os);
        os.flush();
        os.close();
    }

    *//**
     * 用户信息导入
     * @auther zg
     *//*
    @RequestMapping("/import")
    public Result<?> houseImport(@RequestParam("file") MultipartFile file) {
        InputStream is = null;
        XSSFWorkbook hssfWorkbook = null;
        try {
            is = file.getInputStream();
            hssfWorkbook = new XSSFWorkbook(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> userMobiles = userService.getMobiles();
        Set userMobilesresult = new HashSet(userMobiles);
        int updateNumber=0;
        List<User> userList=new ArrayList<>();
        List<UserRole> userRoleList=new ArrayList<>();
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 3; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {


                    XSSFCell nickname = hssfRow.getCell(0);
                    if (nickname == null) {
                        return Result.of(BAD_REQUEST, "工作表的第" + rowNum + "行的用户昵称为空");
                    }
                    nickname.setCellType(nickname.CELL_TYPE_STRING);



                    XSSFCell mobile = hssfRow.getCell(1);
                    if (mobile == null) {
                        return Result.of(BAD_REQUEST, "工作表的第" + rowNum + "行的用户手机号为空");
                    }
                    mobile.setCellType(mobile.CELL_TYPE_STRING);

                    XSSFCell roleName = hssfRow.getCell(2);
                    if (roleName == null) {
                        return Result.of(BAD_REQUEST, "工作表的第" + rowNum + "行的用户角色为空");
                    }
                    roleName.setCellType(roleName.CELL_TYPE_STRING);

                    User user = new User();
                    user.setId(CellGetValue.getValue(mobile));
                    user.setUsername(CellGetValue.getValue(mobile));
                    user.setMobile(CellGetValue.getValue(mobile));
                    user.setPassword("123456");
                    user.setState(YesOrNo.YES);
                    user.setType(UserType.System);
                    user.setNickname(CellGetValue.getValue(nickname));
                    UserRole userRole=new UserRole();
                    userRole.setId(CellGetValue.getValue(mobile));
                    userRole.setUserId(user.getId());
                    if ("1".equals(CellGetValue.getValue(roleName)) || "1.0".equals(CellGetValue.getValue(roleName)) || "超级管理员".equals(CellGetValue.getValue(roleName))){
                        userRole.setRoleId("5ebb9e12d7a66945e1d4f9fc");
                        userRole.setRoleName("超级管理员");
                    }
                    else if ("2".equals(CellGetValue.getValue(roleName)) || "2.0".equals(CellGetValue.getValue(roleName)) || "授权管理员".equals(CellGetValue.getValue(roleName))){
                        userRole.setRoleId("5ebb9e16d7a66945e1d4fa01");
                        userRole.setRoleName("授权管理员");
                    }
                    else if("3".equals(CellGetValue.getValue(roleName)) || "3.0".equals(CellGetValue.getValue(roleName)) || "案场后台".equals(CellGetValue.getValue(roleName))){
                        userRole.setRoleId("5f1fc237f8b70e38284152fd");
                        userRole.setRoleName("案场后台");
                    }
                    else if("4".equals(CellGetValue.getValue(roleName)) || "4.0".equals(CellGetValue.getValue(roleName)) || "置业顾问".equals(CellGetValue.getValue(roleName))){
                        userRole.setRoleId("5f1fc1ebc1abbe1adc47ec4c");
                        userRole.setRoleName("置业顾问");
                    }
                    else {
                        return Result.of(BAD_REQUEST, "工作表的第" + rowNum + "行的角色输入有误");
                    }
                    if (userMobilesresult.contains(CellGetValue.getValue(mobile))) {
                        updateNumber++;
                        userService.update(user);
                        userRoleService.update(userRole);
                    }else{
                        userMobiles.add(CellGetValue.getValue(mobile));
                        userMobilesresult = new HashSet(userMobiles);
                        userList.add(user);
                        userRoleList.add(userRole);
                    }
                }
            }
        }
        if(userList==null || userList.size()==0){
            return Result.ok("此次导入更新："+updateNumber+"条");
        }else{
            userRoleService.save(userRoleList);
            userService.save(userList);
            return Result.ok("此次导入新增："+userList.size()+"条，更新："+updateNumber+"条");
        }
    }


    *//**
     * 用户信息导入
     * @auther zg
     *//*
    @RequestMapping("/importz")
    public Result<?> houseImportz(@RequestParam("file") MultipartFile file) {
        InputStream is = null;
        XSSFWorkbook hssfWorkbook = null;
        try {
            is = file.getInputStream();
            hssfWorkbook = new XSSFWorkbook(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<String> userMobiles = userService.getMobiles();
        Set userMobilesresult = new HashSet(userMobiles);
        int updateNumber=0;
        List<User> userList=new ArrayList<>();
        List<UserRole> userRoleList=new ArrayList<>();
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < hssfWorkbook.getNumberOfSheets(); numSheet++) {
            XSSFSheet hssfSheet = hssfWorkbook.getSheetAt(numSheet);
            if (hssfSheet == null) {
                continue;
            }
            // 循环行Row
            for (int rowNum = 3; rowNum <= hssfSheet.getLastRowNum(); rowNum++) {
                XSSFRow hssfRow = hssfSheet.getRow(rowNum);
                if (hssfRow != null) {


                    XSSFCell nickname = hssfRow.getCell(0);
                    if (nickname == null) {
                        return Result.of(BAD_REQUEST, "工作表的第" + rowNum + "行的用户昵称为空");
                    }
                    nickname.setCellType(nickname.CELL_TYPE_STRING);



                    XSSFCell mobile = hssfRow.getCell(1);
                    if (mobile == null) {
                        return Result.of(BAD_REQUEST, "工作表的第" + rowNum + "行的用户手机号为空");
                    }
                    mobile.setCellType(mobile.CELL_TYPE_STRING);

                    XSSFCell roleName = hssfRow.getCell(2);
                    if (roleName == null) {
                        return Result.of(BAD_REQUEST, "工作表的第" + rowNum + "行的用户角色为空");
                    }
                    roleName.setCellType(roleName.CELL_TYPE_STRING);

                    User user = new User();
                    user.setId(CellGetValue.getValue(mobile));
                    user.setUsername(CellGetValue.getValue(mobile));
                    user.setMobile(CellGetValue.getValue(mobile));
                    user.setPassword("123456");
                    user.setState(YesOrNo.YES);
                    user.setType(UserType.System);
                    user.setNickname(CellGetValue.getValue(nickname));
                    UserRole userRole=new UserRole();
                    userRole.setId(CellGetValue.getValue(mobile));
                    userRole.setUserId(user.getId());
                    if("4".equals(CellGetValue.getValue(roleName)) || "4.0".equals(CellGetValue.getValue(roleName)) || "置业顾问".equals(CellGetValue.getValue(roleName))){
                        userRole.setRoleId("5f1fc1ebc1abbe1adc47ec4c");
                        userRole.setRoleName("置业顾问");
                    }
                    else {
                        return Result.of(BAD_REQUEST, "工作表的第" + rowNum + "行的角色输入有误");
                    }
                    if (userMobilesresult.contains(CellGetValue.getValue(mobile))) {
                        updateNumber++;
                        userService.update(user);
                        userRoleService.update(userRole);
                    }else{
                        userMobiles.add(CellGetValue.getValue(mobile));
                        userMobilesresult = new HashSet(userMobiles);
                        userList.add(user);
                        userRoleList.add(userRole);
                    }
                }
            }
        }
        if(userList==null || userList.size()==0){
            return Result.ok("此次导入更新："+updateNumber+"条");
        }else{
            userRoleService.save(userRoleList);
            userService.save(userList);
            return Result.ok("此次导入新增："+userList.size()+"条，更新："+updateNumber+"条");
        }
    }

*/

}
