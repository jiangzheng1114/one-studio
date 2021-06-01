package org.one.energy.controller;

import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.energy.entity.TCollectConfig;
import org.one.energy.service.TCollectConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/energy/collect")
public class TCollectConfigController {

    private final static Logger logger = LoggerFactory.getLogger(TCollectConfigController.class);

    @Autowired
    private TCollectConfigService TCollectConfigService;

    @RequestMapping(value = "/page")
    @ResponseBody
    public RespEntity<PageInfo<TCollectConfig>> page(HttpServletRequest request, @RequestBody TCollectConfig record){
        return TCollectConfigService.page(record);
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public RespEntity<Boolean> update(HttpServletRequest request, @RequestBody TCollectConfig record){
        return TCollectConfigService.update(record);
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public RespEntity<Boolean> add(HttpServletRequest request, @RequestBody TCollectConfig record){
        return TCollectConfigService.add(record);
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public RespEntity<Boolean> delete(HttpServletRequest request, @RequestBody TCollectConfig record){
        return TCollectConfigService.delete(record.getId());
    }

}
