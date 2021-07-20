package org.one.energy.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.TEnergyData;
import org.one.energy.service.TEnergyDataService;
import org.one.energy.service.TEnterpriseInfoService;
import org.one.energy.service.TRegisterResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import xyz.icrab.common.model.Result;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/energy/data")
public class TEnergyDataController {

    private final static Logger logger = LoggerFactory.getLogger(TEnergyDataController.class);

    @Autowired
    private TEnergyDataService tEnergyDataService;

    @Autowired
    private TRegisterResponseService tRegisterResponseService;

    @Autowired
    private TEnterpriseInfoService  tEnterpriseInfoService;

    @RequestMapping(value = "/page")
    @ResponseBody
    public RespEntity<PageInfo<TEnergyData>> page(HttpServletRequest request, @RequestBody TEnergyData record){
        RespEntity<PageInfo<TEnergyData>> resp = new RespEntity<>();
        try {
            PageInfo<TEnergyData> records = tEnergyDataService.page(record);
            resp.setHttpCode(HttpCode.Success);
            resp.setData(records);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            logger.error("TCollectConfigServiceImpl.page:", e);
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }


    @RequestMapping(value = "/upload")
    @ResponseBody
    public RespEntity<JSONObject> upload(HttpServletRequest request, @RequestBody List<TEnergyData> record){
        return tEnergyDataService.upload(record);
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public RespEntity<Boolean> update(HttpServletRequest request, @RequestBody TEnergyData record){
        return tEnergyDataService.update(record);
    }

    /**
     * 手动填报
     * @param request
     * @return
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Result<?> add(HttpServletRequest request, @RequestBody Map<String,Object> params){

        return tEnergyDataService.insertSelf(params);
    }
}
