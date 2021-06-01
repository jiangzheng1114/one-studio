package org.one.energy.service;

import org.one.common.base.RespEntity;
import org.one.energy.entity.BAdminArea;
import org.one.energy.entity.BProc;

import java.util.List;

public interface BProcService {

    RespEntity<List<BProc>> load();

    RespEntity<Boolean> update(List<BProc> record);

}
