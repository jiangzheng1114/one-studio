package org.one.energy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.BEquipmentClassEntity;
import org.one.energy.entity.TRegisterResponse;
import org.one.energy.mapper.TRegisterResponseMapper;
import org.one.energy.service.TRegisterResponseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class TRegisterResponseServiceImpl implements TRegisterResponseService {

    @Autowired
    private TRegisterResponseMapper tRegisterResponseMapper;

    @Override
    public RespEntity<Boolean> insertSelective(TRegisterResponse tRegisterResponse) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            tRegisterResponse.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            resp.setHttpCode(HttpCode.Success);
            resp.setData(tRegisterResponseMapper.insert(tRegisterResponse) > 0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public List<TRegisterResponse> select() {
        return tRegisterResponseMapper.select();
    }

    @Override
    public TRegisterResponse selectDeviceId() {
        return tRegisterResponseMapper.selectDeviceId();
    }

    @Override
    public PageInfo<TRegisterResponse> page(TRegisterResponse record) {
        PageHelper.startPage(record.getPage(), record.getLimit());
        PageInfo<TRegisterResponse> pageInfo = new PageInfo<>(tRegisterResponseMapper.findByPage(record));
        pageInfo.setSize(tRegisterResponseMapper.findCount(record));
        return pageInfo;

    }
}
