package org.one.energy.controller;

import com.alibaba.fastjson.JSONObject;
import org.one.common.base.RespEntity;
import org.one.energy.entity.TEnergyData;
import org.one.energy.entity.TEnterpriseInfo;
import org.one.energy.service.TEnterpriseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/energy/enterprise")
public class TEnterpriseInfoController {

    @Autowired
    private TEnterpriseInfoService TEnterpriseInfoService;

    @RequestMapping(value = "/getInfo")
    @ResponseBody
    public RespEntity<TEnterpriseInfo> getInfo(HttpServletRequest request){
        return TEnterpriseInfoService.getInfo();
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public RespEntity<Boolean> update(HttpServletRequest request, @RequestBody TEnterpriseInfo record){
        return TEnterpriseInfoService.update(record);
    }

    @RequestMapping(value = "/upload")
    @ResponseBody
    public RespEntity<JSONObject> upload(HttpServletRequest request){
        //, @RequestBody TEnterpriseInfo record
        return TEnterpriseInfoService.upload();
    }
}
