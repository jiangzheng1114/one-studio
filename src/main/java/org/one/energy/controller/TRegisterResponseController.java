package org.one.energy.controller;

import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.TRegisterResponse;
import org.one.energy.service.TRegisterResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/register")
public class TRegisterResponseController {

    @Autowired
    private TRegisterResponseService tRegisterResponseService;


    @RequestMapping(value = "/page")
    @ResponseBody
    public RespEntity<PageInfo<TRegisterResponse>> page(HttpServletRequest request, @RequestBody TRegisterResponse record){
        RespEntity<PageInfo<TRegisterResponse>> resp = new RespEntity<>();
        try {
            PageInfo<TRegisterResponse> records = tRegisterResponseService.page(record);
            resp.setHttpCode(HttpCode.Success);
            resp.setData(records);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @RequestMapping(value = "/selectOne")
    @ResponseBody
    public RespEntity<List<TRegisterResponse>> all(HttpServletRequest request){
        RespEntity<List<TRegisterResponse>> resp = new RespEntity<>();
        try {
            List<TRegisterResponse> areas = tRegisterResponseService.select();
            resp.setHttpCode(HttpCode.Success);
            resp.setData(areas);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }
}
