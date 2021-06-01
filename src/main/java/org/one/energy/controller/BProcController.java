package org.one.energy.controller;

import org.one.common.base.RespEntity;
import org.one.energy.entity.BProc;
import org.one.energy.entity.BProc;
import org.one.energy.service.BProcService;
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
@RequestMapping("/energy/proc")
public class BProcController {

    private final static Logger logger = LoggerFactory.getLogger(BProcController.class);

    @Autowired
    private BProcService BProcService;

    @RequestMapping(value = "/load")
    @ResponseBody
    public RespEntity<List<BProc>> load(HttpServletRequest request){
        return BProcService.load();
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public RespEntity<Boolean> update(HttpServletRequest request, @RequestBody List<BProc> record){
        return BProcService.update(record);
    }

}
