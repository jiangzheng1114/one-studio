package org.one.energy.service;

import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.energy.entity.TRegisterResponse;
import java.util.List;

public interface TRegisterResponseService {
    RespEntity<Boolean> insertSelective(TRegisterResponse tRegisterResponse);

    PageInfo<TRegisterResponse> page(TRegisterResponse record);

    List<TRegisterResponse> select();

    TRegisterResponse selectDeviceId();
}
