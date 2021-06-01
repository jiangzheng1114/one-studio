package org.one.energy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.TCollectConfig;
import org.one.energy.entity.TCollectConfig;
import org.one.energy.entity.TEnterpriseInfo;
import org.one.energy.mapper.TCollectConfigMapper;
import org.one.energy.service.TCollectConfigService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class TCollectConfigServiceImpl implements TCollectConfigService {

    private final static Logger logger = LoggerFactory.getLogger(TCollectConfigServiceImpl.class);

    @Autowired
    private TCollectConfigMapper TCollectConfigMapper;

    @Override
    public RespEntity<Boolean> add(TCollectConfig record) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            resp.setHttpCode(HttpCode.Success);
            resp.setData(TCollectConfigMapper.insertSelective(record) > 0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            logger.error("TCollectConfigServiceImpl.add:", e);
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public RespEntity<Boolean> update(TCollectConfig record) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            resp.setHttpCode(HttpCode.Success);
            resp.setData(TCollectConfigMapper.updateByPrimaryKeySelective(record) > 0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            logger.error("TCollectConfigServiceImpl.update:", e);
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public RespEntity<Boolean> delete(String id) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            resp.setHttpCode(HttpCode.Success);
            resp.setData(TCollectConfigMapper.deleteByPrimaryKey(id) > 0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            logger.error("TCollectConfigServiceImpl.delete:", e);
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public RespEntity<PageInfo<TCollectConfig>> page(TCollectConfig record) {
        RespEntity<PageInfo<TCollectConfig>> resp = new RespEntity<>();
        try {
            PageHelper.startPage(record.getPage(), record.getLimit());
            resp.setHttpCode(HttpCode.Success);
            resp.setData(new PageInfo<>(TCollectConfigMapper.findByPage(record)));
            resp.setMessage("请求成功");
        } catch (Exception e) {
            logger.error("TCollectConfigServiceImpl.page:", e);
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }
}
