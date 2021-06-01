package org.one.energy.service.impl;

import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.BCollectItem;
import org.one.energy.mapper.BCollectItemMapper;
import org.one.energy.service.BCollectItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BCollectItemServiceImpl implements BCollectItemService {

    @Autowired
    private BCollectItemMapper BCollectItemMapper;

    @Override
    public RespEntity<List<BCollectItem>> search(BCollectItem record) {
        RespEntity<List<BCollectItem>> resp = new RespEntity<>();
        List<BCollectItem> list = BCollectItemMapper.search(record);
        resp.setHttpCode(HttpCode.Success);
        resp.setData(list);
        resp.setMessage("请求成功");
        return resp;
    }
}
