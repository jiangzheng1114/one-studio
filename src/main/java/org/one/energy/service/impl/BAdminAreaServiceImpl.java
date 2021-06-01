package org.one.energy.service.impl;

import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.BAdminArea;
import org.one.energy.mapper.BAdminAreaMapper;
import org.one.energy.service.BAdminAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BAdminAreaServiceImpl implements BAdminAreaService {

    @Autowired
    private BAdminAreaMapper BAdminAreaMapper;

    @Override
    public RespEntity<List<BAdminArea>> load() {
        RespEntity<List<BAdminArea>> resp = new RespEntity<>();
        List<BAdminArea> list = BAdminAreaMapper.load();
        resp.setHttpCode(HttpCode.Success);
        resp.setData(list);
        resp.setMessage("请求成功");
        return resp;
    }


}
