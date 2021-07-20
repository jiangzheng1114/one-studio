package org.one.energy.controller;

import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.BEquipmentClassEntity;
import org.one.energy.entity.BProcUnitEntity;
import org.one.energy.service.BEquipmentService;
import org.one.energy.service.BProcUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.icrab.common.model.Result;

import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Map;

import static com.aliyun.mns.sample.HttpEndpoint.logger;

@RestController
@RequestMapping("/procUnit")
public class BProcUnitController {

    @Autowired
    private BProcUnitService bProcUnitService;

    @RequestMapping(value = "/page")
    @ResponseBody
    public RespEntity<PageInfo<BProcUnitEntity>> page(HttpServletRequest request, @RequestBody BProcUnitEntity record){
        RespEntity<PageInfo<BProcUnitEntity>> resp = new RespEntity<>();
        try {
            PageInfo<BProcUnitEntity> records = bProcUnitService.page(record);
            resp.setHttpCode(HttpCode.Success);
            resp.setData(records);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            logger.error("bProcUnitServiceImpl.page:", e);
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public RespEntity<Boolean> update(HttpServletRequest request, @RequestBody BProcUnitEntity record){
        return bProcUnitService.update(record);
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public RespEntity<Boolean> add(HttpServletRequest request, @RequestBody BProcUnitEntity record){
        return bProcUnitService.add(record);
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public RespEntity<Boolean> delete(HttpServletRequest request, @RequestBody BProcUnitEntity record){
        return bProcUnitService.delete(record.getId());
    }
    @RequestMapping(value = "/findByProcId")
    @ResponseBody
    public Result<?> findByProcId(@RequestBody  Map<String,Object> param){
        String procId=(String)param.get("procId");
        List<BProcUnitEntity> list = bProcUnitService.findByProcId(procId);
        return Result.ok(list);
    }

}
