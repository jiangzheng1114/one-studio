package org.one.energy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.one.energy.entity.BCollectItem;

import java.util.List;

/**
 * @Entity org.one.energy.entity.BCollectItem
 */
@Mapper
public interface BCollectItemMapper {

    int deleteByPrimaryKey(String id);

    int insert(BCollectItem record);

    int insertSelective(BCollectItem record);

    BCollectItem selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BCollectItem record);

    int updateByPrimaryKey(BCollectItem record);

    List<BCollectItem> search(BCollectItem record);

}




