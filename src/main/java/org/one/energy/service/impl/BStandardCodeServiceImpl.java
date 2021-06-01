package org.one.energy.service.impl;

import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.BStandardCode;
import org.one.energy.mapper.BStandardCodeMapper;
import org.one.energy.service.BStandardCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BStandardCodeServiceImpl implements BStandardCodeService {

    @Autowired
    private BStandardCodeMapper BStandardCodeMapper;

    @Override
    public RespEntity<List<BStandardCode>> search(String type) {
        RespEntity<List<BStandardCode>> resp = new RespEntity<>();
        List<BStandardCode> list = BStandardCodeMapper.search(type);
        resp.setHttpCode(HttpCode.Success);
        resp.setData(list);
        resp.setMessage("请求成功");
        return resp;
    }
}
