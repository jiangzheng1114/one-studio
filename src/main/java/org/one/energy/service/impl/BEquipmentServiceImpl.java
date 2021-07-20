package org.one.energy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.BEquipmentEntity;
import org.one.energy.mapper.BEquipmentClassMapper;
import org.one.energy.mapper.BEquipmentMapper;
import org.one.energy.mapper.SStandardCollectConfigMapper;
import org.one.energy.service.BEquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class BEquipmentServiceImpl implements BEquipmentService {

    @Autowired
    private BEquipmentMapper bEquipmentMapper;

    @Autowired
    private SStandardCollectConfigMapper sStandardCollectConfigMapper;

    @Override
    public RespEntity<Boolean> add(Map<String,Object> params) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            params.put("id",UUID.randomUUID().toString().replaceAll("-", ""));
            params.put("sId",UUID.randomUUID().toString().replaceAll("-", ""));
            resp.setHttpCode(HttpCode.Success);
            resp.setData(bEquipmentMapper.insertSelective(params) >0);
            resp.setData(sStandardCollectConfigMapper.insert(params)>0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public RespEntity<Boolean> update(Map<String,Object> params) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            resp.setHttpCode(HttpCode.Success);
            String eId = (String)params.get("id");
            resp.setData(sStandardCollectConfigMapper.deleteByPrimaryKey(eId)>0);
            params.put("sId",UUID.randomUUID().toString().replaceAll("-", ""));
            resp.setData(sStandardCollectConfigMapper.insert(params)>0);
            resp.setData(bEquipmentMapper.updateByPrimaryKeySelective(params) > 0);
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
            resp.setData(bEquipmentMapper.deleteByPrimaryKey(id) > 0);
            resp.setData(sStandardCollectConfigMapper.deleteByPrimaryKey(id) > 0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public List<BEquipmentEntity> findAll() {
        return bEquipmentMapper.findAll();
    }

    @Override
    public List<BEquipmentEntity> findByClassCode(Map<String, Object> param) {
        return bEquipmentMapper.findByClassCode(param);
    }

    @Override
    public PageInfo<BEquipmentEntity> page(BEquipmentEntity record) {
        PageHelper.startPage(record.getPage(), record.getLimit());
        PageInfo<BEquipmentEntity> pageInfo = new PageInfo<>(bEquipmentMapper.findByPage(record));
        pageInfo.setSize(bEquipmentMapper.findCount(record));
        return pageInfo;

    }
}
