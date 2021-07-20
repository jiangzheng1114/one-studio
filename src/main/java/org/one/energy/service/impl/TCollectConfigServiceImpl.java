package org.one.energy.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.TCollectConfig;
import org.one.energy.entity.TCollectConfig;
import org.one.energy.entity.TCollectIrtu;
import org.one.energy.entity.TEnterpriseInfo;
import org.one.energy.mapper.TCollectConfigMapper;
import org.one.energy.mapper.TCollectIrtuMapper;
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
    @Autowired
    private TCollectIrtuMapper tCollectIrtuMapper;

    @Override
    public RespEntity<Boolean> add(TCollectConfig record) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            TCollectIrtu tCollectIrtu=new TCollectIrtu();
            tCollectIrtu.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            tCollectIrtu.setItemId(record.getId());
            tCollectIrtu.setCollectUnit(record.getUnit());
            resp.setHttpCode(HttpCode.Success);
            resp.setData(TCollectConfigMapper.insert(record) > 0);
            resp.setData(tCollectIrtuMapper.insert(tCollectIrtu)>0);
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
            resp.setData(tCollectIrtuMapper.deleteByPrimaryKey(id) > 0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            logger.error("TCollectConfigServiceImpl.delete:", e);
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public PageInfo<TCollectConfig> page(TCollectConfig record) {
        PageHelper.startPage(record.getPage(), record.getLimit());
        PageInfo<TCollectConfig> pageInfo = new PageInfo<>(TCollectConfigMapper.findByPage(record));
        pageInfo.setSize(TCollectConfigMapper.findCount(record));
        return pageInfo;

    }

}
