package org.one.energy.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.one.energy.entity.TEnergyData;
import org.one.system.entity.OneDept;

import java.util.List;

/**
 * @Entity org.one.energy.entity.TEnergyData
 */
@Mapper
public interface TEnergyDataMapper {

    int deleteByPrimaryKey(String id);

    int insert(TEnergyData record);

    int insertSelective(TEnergyData record);

    TEnergyData selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TEnergyData record);

    int updateByPrimaryKey(TEnergyData record);

    Page<TEnergyData> findByPage(TEnergyData record);

}




