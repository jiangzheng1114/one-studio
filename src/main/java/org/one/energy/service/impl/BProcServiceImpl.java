package org.one.energy.service.impl;

import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.BProc;
import org.one.energy.entity.BProc;
import org.one.energy.mapper.BProcMapper;
import org.one.energy.service.BProcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BProcServiceImpl implements BProcService {

    private final static Logger logger = LoggerFactory.getLogger(BProcServiceImpl.class);

    @Autowired
    private BProcMapper BProcMapper;

    @Override
    public RespEntity<List<BProc>> load() {
        RespEntity<List<BProc>> resp = new RespEntity<>();
        List<BProc> list = BProcMapper.load();
        resp.setHttpCode(HttpCode.Success);
        resp.setData(list);
        resp.setMessage("请求成功");
        return resp;
    }

    @Override
    public RespEntity<Boolean> update(List<BProc> record) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            resp.setHttpCode(HttpCode.Success);
            BProcMapper.truncateTProc();
            for(BProc item : record) {
                if("1".equals(item.getCheckStatus())) {
                    BProcMapper.insertTProc(item);
                }
            }
            resp.setData(true);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            logger.error("BProcServiceImpl.update:", e);
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }
}
