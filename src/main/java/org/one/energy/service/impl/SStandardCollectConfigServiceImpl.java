package org.one.energy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.BProcUnitEntity;
import org.one.energy.entity.SStandardCollectConfigEntity;
import org.one.energy.mapper.BProcUnitMapper;
import org.one.energy.mapper.SStandardCollectConfigMapper;
import org.one.energy.service.SStandardCollectConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class SStandardCollectConfigServiceImpl implements SStandardCollectConfigService {

    @Autowired
    private SStandardCollectConfigMapper sStandardCollectConfigMapper;

    @Override
    public RespEntity<Boolean> add(Map<String,Object> params) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            params.put("id",UUID.randomUUID().toString().replaceAll("-", ""));
            resp.setHttpCode(HttpCode.Success);
            resp.setData(sStandardCollectConfigMapper.insert(params) > 0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public RespEntity<Boolean> update(SStandardCollectConfigEntity record) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            resp.setHttpCode(HttpCode.Success);
            resp.setData(sStandardCollectConfigMapper.updateByPrimaryKeySelective(record) > 0);
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
            resp.setData(sStandardCollectConfigMapper.deleteByPrimaryKey(id) > 0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

}
