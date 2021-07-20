package org.one.energy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.BEquipmentClassEntity;
import org.one.energy.entity.TCollectConfig;
import org.one.energy.mapper.BEquipmentClassMapper;
import org.one.energy.service.BEquipmentClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BEquipmentClassServiceImpl implements BEquipmentClassService {
    
    @Autowired
    private BEquipmentClassMapper bEquipmentClassMapper;

    @Override
    public RespEntity<Boolean> add(BEquipmentClassEntity record) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            resp.setHttpCode(HttpCode.Success);
            resp.setData(bEquipmentClassMapper.insertSelective(record) > 0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public RespEntity<Boolean> update(BEquipmentClassEntity record) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            resp.setHttpCode(HttpCode.Success);
            resp.setData(bEquipmentClassMapper.updateByPrimaryKeySelective(record) > 0);
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
            resp.setData(bEquipmentClassMapper.deleteByPrimaryKey(id) > 0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public List<BEquipmentClassEntity> findAll() {
        return bEquipmentClassMapper.findAll();
    }

    @Override
    public PageInfo<BEquipmentClassEntity> page(BEquipmentClassEntity record) {
        PageHelper.startPage(record.getPage(), record.getLimit());
        PageInfo<BEquipmentClassEntity> pageInfo = new PageInfo<>(bEquipmentClassMapper.findByPage(record));
        pageInfo.setSize(bEquipmentClassMapper.findCount(record));
        return pageInfo;

    }
}
