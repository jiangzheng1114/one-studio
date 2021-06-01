package org.one.energy.service;

import org.one.common.base.RespEntity;
import org.one.energy.entity.BCollectItem;

import java.util.List;

public interface BCollectItemService {

    RespEntity<List<BCollectItem>> search(BCollectItem record);

}
