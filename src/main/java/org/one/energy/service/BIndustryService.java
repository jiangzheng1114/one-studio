package org.one.energy.service;

import org.one.common.base.RespEntity;
import org.one.energy.entity.BAdminArea;
import org.one.energy.entity.BIndustry;

import java.util.List;

public interface BIndustryService {

    RespEntity<List<BIndustry>> load();

}
