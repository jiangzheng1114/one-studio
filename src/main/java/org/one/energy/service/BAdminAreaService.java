package org.one.energy.service;

import org.one.common.base.RespEntity;
import org.one.energy.entity.BAdminArea;

import java.util.List;

public interface BAdminAreaService {

    RespEntity<List<BAdminArea>> load();

}
