package org.one.energy.service;

import org.one.common.base.RespEntity;
import org.one.energy.entity.BStandardCode;
import org.one.energy.entity.SStandardCode;

import java.util.List;

public interface BStandardCodeService {

    RespEntity<List<BStandardCode>> search(String type);

}
