package org.one.energy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.BEquipmentEntity;
import org.one.energy.entity.BProcUnitEntity;
import org.one.energy.mapper.BEquipmentMapper;
import org.one.energy.mapper.BProcUnitMapper;
import org.one.energy.service.BProcUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BProcUnitServiceImpl implements BProcUnitService {
    @Autowired
    private BProcUnitMapper bProcUnitMapper;

    @Override
    public RespEntity<Boolean> add(BProcUnitEntity record) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            resp.setHttpCode(HttpCode.Success);
            resp.setData(bProcUnitMapper.insertSelective(record) > 0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public RespEntity<Boolean> update(BProcUnitEntity record) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            resp.setHttpCode(HttpCode.Success);
            resp.setData(bProcUnitMapper.updateByPrimaryKeySelective(record) > 0);
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
            resp.setData(bProcUnitMapper.deleteByPrimaryKey(id) > 0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public List<BProcUnitEntity> findByProcId(String procId) {
        return bProcUnitMapper.findAll(procId);
    }


    @Override
    public PageInfo<BProcUnitEntity> page(BProcUnitEntity record) {
        PageHelper.startPage(record.getPage(), record.getLimit());
        PageInfo<BProcUnitEntity> pageInfo = new PageInfo<>(bProcUnitMapper.findByPage(record));
        pageInfo.setSize(bProcUnitMapper.findCount(record));
        return pageInfo;

    }
}
