package org.one.energy.controller;

import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.BEquipmentClassEntity;
import org.one.energy.service.BEquipmentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.icrab.common.model.Result;

import javax.servlet.http.HttpServletRequest;

import java.util.List;

import static com.aliyun.mns.sample.HttpEndpoint.logger;

@RestController
@RequestMapping("/equipmentClass")
public class BEquipmentClassController {

    @Autowired
    private BEquipmentClassService bEquipmentClassService;

    @RequestMapping(value = "/page")
    @ResponseBody
    public RespEntity<PageInfo<BEquipmentClassEntity>> page(HttpServletRequest request, @RequestBody BEquipmentClassEntity record){
        RespEntity<PageInfo<BEquipmentClassEntity>> resp = new RespEntity<>();
        try {
            PageInfo<BEquipmentClassEntity> records = bEquipmentClassService.page(record);
            resp.setHttpCode(HttpCode.Success);
            resp.setData(records);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public RespEntity<Boolean> update(HttpServletRequest request, @RequestBody BEquipmentClassEntity record){
        return bEquipmentClassService.update(record);
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public RespEntity<Boolean> add(HttpServletRequest request, @RequestBody BEquipmentClassEntity record){
        return bEquipmentClassService.add(record);
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public RespEntity<Boolean> delete(HttpServletRequest request, @RequestBody BEquipmentClassEntity record){
        return bEquipmentClassService.delete(record.getId());
    }

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public Result<?> findAll(HttpServletRequest request){
        return Result.ok(bEquipmentClassService.findAll());
    }

}
