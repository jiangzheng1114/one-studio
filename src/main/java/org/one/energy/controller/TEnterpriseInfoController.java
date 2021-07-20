package org.one.energy.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import org.one.common.base.RespEntity;
import org.one.energy.common.HttpsUtil;
import org.one.energy.entity.TEnterpriseInfo;
import org.one.energy.service.TEnterpriseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.icrab.common.model.Result;
import xyz.icrab.common.model.Status;
import xyz.icrab.common.web.annotation.PermissionMode;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/energy/enterprise")
public class TEnterpriseInfoController {

    @Autowired
    private TEnterpriseInfoService tEnterpriseInfoService;

    @RequestMapping(value = "/getInfo")
    @ResponseBody
    public RespEntity<TEnterpriseInfo> getInfo(HttpServletRequest request){
        return tEnterpriseInfoService.getInfo();
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public RespEntity<Boolean> update(HttpServletRequest request, @RequestBody TEnterpriseInfo record){
        String code = record.getCode();
        TEnterpriseInfo tEnterpriseInfo=tEnterpriseInfoService.findByCode(code);
        if(tEnterpriseInfo==null){
            return tEnterpriseInfoService.insert(record);
        }
            return tEnterpriseInfoService.update(record);
    }

    @RequestMapping(value = "/upload")
    @ResponseBody
    public RespEntity<JSONObject> upload(HttpServletRequest request,@RequestBody  Map<String,Object> params){
        //, @RequestBody TEnterpriseInfo record
        return tEnterpriseInfoService.upload(params);
    }

}
