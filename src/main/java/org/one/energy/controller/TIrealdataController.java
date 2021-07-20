package org.one.energy.controller;

import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.TIrealdata;
import org.one.energy.service.TIrealdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/irealdata")
public class TIrealdataController {

    @Autowired
    private TIrealdataService tIrealdataService;

    @RequestMapping(value = "/all")
    @ResponseBody
    public RespEntity<List<TIrealdata>> all(HttpServletRequest request){
        RespEntity<List<TIrealdata>> resp = new RespEntity<>();
        try {
            List<TIrealdata> areas = tIrealdataService.selectAll();
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
