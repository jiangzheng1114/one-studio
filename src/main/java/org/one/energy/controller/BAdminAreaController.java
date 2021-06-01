package org.one.energy.controller;

import org.one.common.base.RespEntity;
import org.one.energy.entity.BAdminArea;
import org.one.energy.service.BAdminAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/energy/area")
public class BAdminAreaController {

    @Autowired
    private BAdminAreaService BAdminAreaService;

    @RequestMapping(value = "/load")
    @ResponseBody
    public RespEntity<List<BAdminArea>> load(HttpServletRequest request){
        return BAdminAreaService.load();
    }
}
