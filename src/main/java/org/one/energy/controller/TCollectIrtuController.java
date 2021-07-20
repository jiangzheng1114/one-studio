package org.one.energy.controller;

import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.BEquipmentEntity;
import org.one.energy.entity.TCollectConfig;
import org.one.energy.entity.TCollectIrtu;
import org.one.energy.service.TCollectConfigService;
import org.one.energy.service.TCollectIrtuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

import java.util.Map;

import static com.aliyun.mns.sample.HttpEndpoint.logger;

@RestController
@RequestMapping("/collectIrul")
public class TCollectIrtuController {

    @Autowired
    private TCollectIrtuService tCollectIrtuService;

    @RequestMapping(value = "/page")
    @ResponseBody
    public RespEntity<PageInfo<TCollectIrtu>> page(HttpServletRequest request, @RequestBody Map<String,Object> params){
        RespEntity<PageInfo<TCollectIrtu>> resp = new RespEntity<>();
        try {
            PageInfo<TCollectIrtu> records = tCollectIrtuService.page(params);
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
    public RespEntity<Boolean> update(HttpServletRequest request, @RequestBody TCollectIrtu record){
        return tCollectIrtuService.update(record);
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public RespEntity<Boolean> add(HttpServletRequest request, @RequestBody TCollectIrtu record){
        return tCollectIrtuService.add(record);
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public RespEntity<Boolean> delete(HttpServletRequest request, @RequestBody TCollectIrtu record){
        return tCollectIrtuService.delete(record.getId());
    }

}
