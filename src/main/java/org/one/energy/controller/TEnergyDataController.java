package org.one.energy.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.common.HttpsEnergy;
import org.one.energy.entity.TEnergyData;
import org.one.energy.service.TEnergyDataService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/energy/data")
public class TEnergyDataController {

    private final static Logger logger = LoggerFactory.getLogger(TEnergyDataController.class);

    @Autowired
    private TEnergyDataService TEnergyDataService;

    @RequestMapping(value = "/page")
    @ResponseBody
    public RespEntity<PageInfo<TEnergyData>> page(HttpServletRequest request, @RequestBody TEnergyData record){
        return TEnergyDataService.page(record);
    }

    @RequestMapping(value = "/upload")
    @ResponseBody
    public RespEntity<JSONObject> upload(HttpServletRequest request, @RequestBody List<TEnergyData> record){
        return TEnergyDataService.upload(record);
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public RespEntity<Boolean> update(HttpServletRequest request, @RequestBody TEnergyData record){
        return TEnergyDataService.update(record);
    }
}
