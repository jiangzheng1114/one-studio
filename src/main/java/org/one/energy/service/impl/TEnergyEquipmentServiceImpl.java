package org.one.energy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.TEnergyEquipment;
import org.one.energy.mapper.TEnergyEquipmentMapper;
import org.one.energy.service.TEnergyEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class TEnergyEquipmentServiceImpl implements TEnergyEquipmentService {

    @Autowired
    private TEnergyEquipmentMapper tEnergyEquipmentMapper;

    @Override
    public RespEntity<Boolean> add(TEnergyEquipment record) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            resp.setHttpCode(HttpCode.Success);
            resp.setData(tEnergyEquipmentMapper.insertSelective(record) > 0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public RespEntity<Boolean> update(TEnergyEquipment record) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            resp.setHttpCode(HttpCode.Success);
            resp.setData(tEnergyEquipmentMapper.updateByPrimaryKeySelective(record) > 0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public RespEntity<Boolean> delete(String id) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            resp.setHttpCode(HttpCode.Success);
            resp.setData(tEnergyEquipmentMapper.delete(id)>0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public List<TEnergyEquipment> selectAll() {
        return tEnergyEquipmentMapper.selectAll();
    }

    @Override
    public PageInfo<TEnergyEquipment> page(TEnergyEquipment record) {
        PageHelper.startPage(record.getPage(), record.getLimit());
        PageInfo<TEnergyEquipment> pageInfo = new PageInfo<>(tEnergyEquipmentMapper.findByPage(record));
        pageInfo.setSize(tEnergyEquipmentMapper.findCount(record));
        return pageInfo;

    }
}
