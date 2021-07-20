package org.one.energy.service;

import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.energy.entity.TPlatRegisterResponseExtendsEntity;

import java.util.Map;

public interface TPlatRegisterResponseExtendsService {
    PageInfo<TPlatRegisterResponseExtendsEntity> page(TPlatRegisterResponseExtendsEntity record);

}

