package org.one.energy.controller;

import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.TPlatVersionResponse;
import org.one.energy.service.TPlatVersionResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/platVersion")
public class TPlatVersionResponseController {
    @Autowired
    private TPlatVersionResponseService tPlatVersionResponseService;

    @RequestMapping(value = "/page")
    @ResponseBody
    public RespEntity<PageInfo<TPlatVersionResponse>> page(HttpServletRequest request, @RequestBody TPlatVersionResponse record){
        RespEntity<PageInfo<TPlatVersionResponse>> resp = new RespEntity<>();
        try {
            PageInfo<TPlatVersionResponse> records = tPlatVersionResponseService.page(record);
            resp.setHttpCode(HttpCode.Success);
            resp.setData(records);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

}
