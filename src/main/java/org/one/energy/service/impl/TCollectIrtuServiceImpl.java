package org.one.energy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.TCollectConfig;
import org.one.energy.entity.TCollectIrtu;
import org.one.energy.mapper.TCollectConfigMapper;
import org.one.energy.mapper.TCollectIrtuMapper;
import org.one.energy.service.TCollectConfigService;
import org.one.energy.service.TCollectIrtuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class TCollectIrtuServiceImpl implements TCollectIrtuService {

    @Autowired
    private TCollectIrtuMapper tCollectIrtuMapper;

    @Override
    public RespEntity<Boolean> add(TCollectIrtu record) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            resp.setHttpCode(HttpCode.Success);
            resp.setData(tCollectIrtuMapper.insertSelective(record) > 0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public RespEntity<Boolean> update(TCollectIrtu record) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            resp.setHttpCode(HttpCode.Success);
            resp.setData(tCollectIrtuMapper.updateByPrimaryKey(record) > 0);
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
            resp.setData(tCollectIrtuMapper.deleteByPrimaryKey(id) > 0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }
    
    @Override
    public PageInfo<TCollectIrtu> page(Map<String,Object> params) {
        PageHelper.startPage(Integer.parseInt(String.valueOf(params.get("page"))),Integer.parseInt(String.valueOf(params.get("limit"))));
        PageInfo<TCollectIrtu> pageInfo = new PageInfo<>(tCollectIrtuMapper.findByPage(params));
        pageInfo.setSize(tCollectIrtuMapper.findCount(params));
        return pageInfo;

    }

}
