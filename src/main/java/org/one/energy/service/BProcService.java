package org.one.energy.service;

import com.github.pagehelper.PageInfo;
import org.one.common.base.RespEntity;
import org.one.energy.entity.BAdminArea;
import org.one.energy.entity.BProc;
import org.one.energy.entity.TCollectConfig;

import java.util.List;

public interface BProcService {

    RespEntity<List<BProc>> load();

    RespEntity<Boolean> update(BProc record);

    PageInfo<BProc> page(BProc record);

    RespEntity<Boolean> add(BProc record);

    RespEntity<Boolean> delete(String id);
}
