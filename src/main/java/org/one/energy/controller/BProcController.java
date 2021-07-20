package org.one.energy.controller;

import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
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
    private BProcService bProcService;

    @RequestMapping(value = "/page")
    @ResponseBody
    public RespEntity<PageInfo<BProc>> page(HttpServletRequest request, @RequestBody BProc record){
        RespEntity<PageInfo<BProc>> resp = new RespEntity<>();
        try {
            PageInfo<BProc> records = bProcService.page(record);
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

    @RequestMapping(value = "/load")
    @ResponseBody
    public RespEntity<List<BProc>> load(HttpServletRequest request){
        return bProcService.load();
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public RespEntity<Boolean> update(HttpServletRequest request, @RequestBody BProc record){
        return bProcService.update(record);
    }


    @RequestMapping(value = "/add")
    @ResponseBody
    public RespEntity<Boolean> add(HttpServletRequest request, @RequestBody BProc record){
        return bProcService.add(record);
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public RespEntity<Boolean> delete(HttpServletRequest request, @RequestBody BProc record){
        return bProcService.delete(record.getId());
    }

}
