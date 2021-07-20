package org.one.energy.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.common.base.code.HttpCode;
import org.one.energy.entity.BProc;
import org.one.energy.entity.BProc;
import org.one.energy.entity.TCollectConfig;
import org.one.energy.mapper.BProcMapper;
import org.one.energy.service.BProcService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class BProcServiceImpl implements BProcService {

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
    public RespEntity<Boolean> update(BProc record) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            resp.setHttpCode(HttpCode.Success);
            resp.setData(BProcMapper.updateByPrimaryKeySelective(record) > 0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

    @Override
    public PageInfo<BProc> page(BProc record) {
        PageHelper.startPage(record.getPage(), record.getLimit());
        PageInfo<BProc> pageInfo = new PageInfo<>(BProcMapper.findByPage(record));
        pageInfo.setSize(BProcMapper.findCount(record));
        return pageInfo;

    }

    @Override
    public RespEntity<Boolean> add(BProc record) {
        RespEntity<Boolean> resp = new RespEntity<>();
        try {
            record.setId(UUID.randomUUID().toString().replaceAll("-", ""));
            resp.setHttpCode(HttpCode.Success);
            resp.setData(BProcMapper.insert(record) > 0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
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
            resp.setData(BProcMapper.deleteByPrimaryKey(id) > 0);
            resp.setMessage("请求成功");
        } catch (Exception e) {
            resp.setHttpCode(HttpCode.Error);
            resp.setMessage("请求失败");
        }
        return resp;
    }

}
