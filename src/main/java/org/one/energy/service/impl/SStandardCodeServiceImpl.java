package org.one.energy.service.impl;

import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.SStandardCode;
import org.one.energy.mapper.SStandardCodeMapper;
import org.one.energy.service.SStandardCodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SStandardCodeServiceImpl implements SStandardCodeService {

    @Autowired
    private SStandardCodeMapper SStandardCodeMapper;

    @Override
    public RespEntity<List<SStandardCode>> search(SStandardCode record) {
        RespEntity<List<SStandardCode>> resp = new RespEntity<>();
        List<SStandardCode> list = SStandardCodeMapper.search(record);
        resp.setHttpCode(HttpCode.Success);
        resp.setData(list);
        resp.setMessage("请求成功");
        return resp;
    }
}
