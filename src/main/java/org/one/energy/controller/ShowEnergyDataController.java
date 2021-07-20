package org.one.energy.controller;

import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.TEnergyEquipment;
import org.one.energy.service.TEnergyDataService;
import org.one.energy.service.TEnergyEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("/showData")
public class ShowEnergyDataController {

    @Autowired
    private TEnergyEquipmentService tEnergyEquipmentService;

    @Autowired
    private TEnergyDataService tEnergyDataService;

    @RequestMapping("/datas")
    @ResponseBody
    public RespEntity<Map> all(HttpServletRequest request,@RequestBody Map<String,Object> map){
        RespEntity<Map> resp = new RespEntity<>();
        String stat = (String)map.get("stat");
        try {
            List<TEnergyEquipment> tEnergyEquipmentList = tEnergyEquipmentService.selectAll();
            Map<String,Object> param=new HashMap<>();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date=new Date();
            for(int i=0;i<tEnergyEquipmentList.size();i++){
                Map<String,Object> params=new HashMap<>();
                String energyType = tEnergyEquipmentList.get(i).getEnergyType();
                String ramark = tEnergyEquipmentList.get(i).getRemark();
                String equipmentKeys = tEnergyEquipmentList.get(i).getEquipmentKeys();
                List ikeys=new ArrayList();
                ikeys.addAll(Arrays.asList(equipmentKeys.split(",")));
                String energyUse=null;
                if(stat!=null && !stat.equals("")){
                    if (stat.equals("日")){
                        energyUse = tEnergyDataService.sumEnergyUse(ikeys, currDay(), sdf.format(date));
                    }
                    else if (stat.equals("月")){
                        energyUse = tEnergyDataService.sumEnergyUse(ikeys, currMonth(), sdf.format(date));
                    }
                    else{
                        energyUse = tEnergyDataService.sumEnergyUse(ikeys, currYear(), sdf.format(date));
                    }
                } else{
                    String startTime=(String)map.get("startTime");
                    String endTime=(String)map.get("endTime");
                    energyUse = tEnergyDataService.sumEnergyUse(ikeys,startTime,endTime);
                }
                params.put("value",energyUse);
                params.put("equivalentStandard",tEnergyEquipmentList.get(i).getEquivalentStandard());
                params.put("ramark",ramark);
                param.put(energyType,params);
            }

            resp.setHttpCode(HttpCode.Success);
            resp.setData(param);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    //获取当天00:00:00
    private String currDay(){
        Calendar calendar=Calendar.getInstance();
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String month = String.valueOf(calendar.get(Calendar.MONTH)+1);
        String day = String.valueOf(calendar.get(Calendar.DATE));
        String currDay=year+"-"+month+"-"+day+" 00:00:00";
        return currDay;
    }
    // 获取当前月第一天（1号 00:00:00）
    private String currMonth(){
        Calendar calendar=Calendar.getInstance();
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String month = String.valueOf(calendar.get(Calendar.MONTH)+1);
        String currMonth=year+"-"+month+"-"+"01 00:00:00";
        return currMonth;
    }
    //获取当年第一天（1月1号 00:00:00）
    private String currYear(){
        Calendar calendar=Calendar.getInstance();
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String currYear=year+"-"+"01-01 00:00:00";
        return currYear;
    }

/*
    public static void main(String[] args) {
       */
/* Calendar calendar=Calendar.getInstance();
        String year = String.valueOf(calendar.get(Calendar.YEAR));
        String currDay=year+"-"+"01-01 00:00:00";*//*

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
//        startTime -> 2021-07-07T09:27:37.447Z
        System.out.println(date);
        System.out.println(date);
    }
*/


}
