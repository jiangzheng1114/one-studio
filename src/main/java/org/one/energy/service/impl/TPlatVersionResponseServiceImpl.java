package org.one.energy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.TCollectConfig;
import org.one.energy.entity.TPlatVersionResponse;
import org.one.energy.mapper.TPlatVersionResponseMapper;
import org.one.energy.service.TPlatVersionResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
public class TPlatVersionResponseServiceImpl implements TPlatVersionResponseService {

    @Autowired
    private TPlatVersionResponseMapper tPlatVersionResponseMapper;

    @Override
    public RespEntity<Boolean> insertSelective(Map<String,Object> param) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            param.put("id", UUID.randomUUID().toString().replaceAll("-", ""));
            resp.setHttpCode(HttpCode.Success);
            resp.setData(tPlatVersionResponseMapper.insert(param) > 0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public PageInfo<TPlatVersionResponse> page(TPlatVersionResponse record) {
        PageHelper.startPage(record.getPage(), record.getLimit());
        PageInfo<TPlatVersionResponse> pageInfo = new PageInfo<>(tPlatVersionResponseMapper.findByPage(record));
        pageInfo.setSize(tPlatVersionResponseMapper.findCount(record));
        return pageInfo;

    }
}
