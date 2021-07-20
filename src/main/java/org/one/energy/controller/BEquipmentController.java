package org.one.energy.controller;

import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.BEquipmentClassEntity;
import org.one.energy.entity.BEquipmentEntity;
import org.one.energy.service.BEquipmentClassService;
import org.one.energy.service.BEquipmentService;
import org.one.energy.service.SStandardCollectConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.icrab.common.model.Result;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;
import java.util.UUID;

import static com.aliyun.mns.sample.HttpEndpoint.logger;

@RestController
@RequestMapping("/equipment")
public class BEquipmentController {

    @Autowired
    private BEquipmentService bEquipmentService;

    @Autowired
    private SStandardCollectConfigService sStandardCollectConfigService;


    @RequestMapping(value = "/page")
    @ResponseBody
    public RespEntity<PageInfo<BEquipmentEntity>> page(HttpServletRequest request, @RequestBody BEquipmentEntity record){
        RespEntity<PageInfo<BEquipmentEntity>> resp = new RespEntity<>();
        try {
            PageInfo<BEquipmentEntity> records = bEquipmentService.page(record);
            resp.setHttpCode(HttpCode.Success);
            resp.setData(records);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            logger.error("bEquipmentServiceImpl.page:", e);
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @RequestMapping(value = "/update")
    @ResponseBody
    public RespEntity<Boolean> update(HttpServletRequest request, @RequestBody Map<String,Object> params){

        return bEquipmentService.update(params);
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public RespEntity<Boolean> add(HttpServletRequest request, @RequestBody Map<String,Object> params){

        return bEquipmentService.add(params);
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public RespEntity<Boolean> delete(HttpServletRequest request, @RequestBody BEquipmentEntity record){
        return bEquipmentService.delete(record.getId());
    }

    @RequestMapping(value = "/findAll")
    @ResponseBody
    public Result<?> findAll(HttpServletRequest request){
        return Result.ok(bEquipmentService.findAll());
    }

    @RequestMapping(value = "/findByClassCode")
    @ResponseBody
    public Result<?> findByClassCode(HttpServletRequest request,@RequestBody Map<String,Object> param){
        return Result.ok(bEquipmentService.findByClassCode(param));
    }

}
