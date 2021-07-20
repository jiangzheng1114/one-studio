package org.one.energy.controller;

import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.TEnergyEquipment;
import org.one.energy.service.TEnergyEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/energyEquipment")
public class TEnergyEquipmentController {

    @Autowired
    private TEnergyEquipmentService tEnergyEquipmentService;

    @RequestMapping(value = "/page")
    @ResponseBody
    public RespEntity<PageInfo<TEnergyEquipment>> page(HttpServletRequest request, @RequestBody TEnergyEquipment record){
        RespEntity<PageInfo<TEnergyEquipment>> resp = new RespEntity<>();
        try {
            PageInfo<TEnergyEquipment> records = tEnergyEquipmentService.page(record);
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
    public RespEntity<Boolean> update(HttpServletRequest request, @RequestBody TEnergyEquipment record){
        return tEnergyEquipmentService.update(record);
    }

    @RequestMapping(value = "/add")
    @ResponseBody
    public RespEntity<Boolean> add(HttpServletRequest request, @RequestBody TEnergyEquipment record){
        return tEnergyEquipmentService.add(record);
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public RespEntity<Boolean> delete(HttpServletRequest request, @RequestBody TEnergyEquipment record){
        return tEnergyEquipmentService.delete(record.getId());
    }

    @RequestMapping(value = "/all")
    @ResponseBody
    public RespEntity<List<TEnergyEquipment>> all(HttpServletRequest request){
        RespEntity<List<TEnergyEquipment>> resp = new RespEntity<>();
        try {
            List<TEnergyEquipment> areas = tEnergyEquipmentService.selectAll();
            resp.setHttpCode(HttpCode.Success);
            resp.setData(areas);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }
}
