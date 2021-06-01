package org.one.energy.service.impl;

import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.BIndustry;
import org.one.energy.entity.BIndustry;
import org.one.energy.mapper.BIndustryMapper;
import org.one.energy.service.BIndustryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BIndustryServiceImpl implements BIndustryService {
    
    @Autowired
    private BIndustryMapper BIndustryMapper;

    @Override
    public RespEntity<List<BIndustry>> load() {
        RespEntity<List<BIndustry>> resp = new RespEntity<>();
        List<BIndustry> list = BIndustryMapper.load();
        resp.setHttpCode(HttpCode.Success);
        resp.setData(list);
        resp.setMessage("请求成功");
        return resp;
    }
}
