package org.one.energy.service;

import org.one.common.base.RespEntity;
import org.one.energy.entity.SStandardCode;

import java.util.List;

public interface SStandardCodeService {

    RespEntity<List<SStandardCode>> search(SStandardCode record);

}
