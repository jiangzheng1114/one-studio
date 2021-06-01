package org.one.energy.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.one.energy.entity.TCollectConfig;
import org.one.energy.entity.TCollectConfig;

import java.util.List;

/**
 * @Entity org.one.energy.entity.TCollectConfig
 */
@Mapper
public interface TCollectConfigMapper {

    int deleteByPrimaryKey(String id);

    int insert(TCollectConfig record);

    int insertSelective(TCollectConfig record);

    TCollectConfig selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TCollectConfig record);

    int updateByPrimaryKey(TCollectConfig record);

    Page<TCollectConfig> findByPage(TCollectConfig record);

    List<TCollectConfig> searchByIkey(String ikey);

}




