package org.one.energy.controller;


import org.one.common.base.RespEntity;
import org.one.energy.entity.BCollectItem;
import org.one.energy.entity.BIndustry;
import org.one.energy.entity.BStandardCode;
import org.one.energy.entity.SStandardCode;
import org.one.energy.service.BCollectItemService;
import org.one.energy.service.BIndustryService;
import org.one.energy.service.BStandardCodeService;
import org.one.energy.service.SStandardCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/energy/dict")
public class DictController {

    @Autowired
    private SStandardCodeService SStandardCodeService;

    @Autowired
    private BStandardCodeService BStandardCodeService;

    @Autowired
    private BIndustryService BIndustryService;

    @Autowired
    private org.one.energy.service.BCollectItemService BCollectItemService;

    @RequestMapping(value = "/searchSStandard")
    @ResponseBody
    public RespEntity<List<SStandardCode>> searchSStandard(HttpServletRequest request, @RequestBody SStandardCode record){
        return SStandardCodeService.search(record);
    }

    @RequestMapping(value = "/searchBCollectItem")
    @ResponseBody
    public RespEntity<List<BCollectItem>> searchBCollectItem(HttpServletRequest request, @RequestBody BCollectItem record){
        return BCollectItemService.search(record);
    }

    @RequestMapping(value = "/searchBStandard")
    @ResponseBody
    public RespEntity<List<BStandardCode>> searchBStandard(HttpServletRequest request, @RequestParam String type){
        return BStandardCodeService.search(type);
    }

    @RequestMapping(value = "/searchBIndustry")
    @ResponseBody
    public RespEntity<List<BIndustry>> searchBIndustry(HttpServletRequest request){
        return BIndustryService.load();
    }
}
