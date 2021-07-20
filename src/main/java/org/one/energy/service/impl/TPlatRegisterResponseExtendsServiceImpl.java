package org.one.energy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.SStandardCollectConfigEntity;
import org.one.energy.entity.TPlatRegisterResponseExtendsEntity;
import org.one.energy.mapper.SStandardCollectConfigMapper;
import org.one.energy.mapper.TPlatRegisterResponseExtendsMappper;
import org.one.energy.service.TPlatRegisterResponseExtendsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TPlatRegisterResponseExtendsServiceImpl implements TPlatRegisterResponseExtendsService {

    @Autowired
    private TPlatRegisterResponseExtendsMappper tPlatRegisterResponseExtendsMappper;
    @Override
    public PageInfo<TPlatRegisterResponseExtendsEntity> page(TPlatRegisterResponseExtendsEntity record) {
        PageHelper.startPage(record.getPage(), record.getLimit());
        PageInfo<TPlatRegisterResponseExtendsEntity> pageInfo = new PageInfo<>(tPlatRegisterResponseExtendsMappper.findByPage(record));
        pageInfo.setSize(tPlatRegisterResponseExtendsMappper.findCount(record));
        return pageInfo;

    }
}
