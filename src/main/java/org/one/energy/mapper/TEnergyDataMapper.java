package org.one.energy.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.one.common.base.RespEntity;
import org.one.energy.entity.TEnergyData;
import org.one.energy.entity.TEnterpriseInfo;
import org.one.system.entity.OneDept;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @Entity org.one.energy.entity.TEnergyData
 */
@Mapper
public interface TEnergyDataMapper {

    int deleteByPrimaryKey(String id);

    int insert(TEnergyData record);

    TEnergyData selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TEnergyData record);

    int updateByPrimaryKey(TEnergyData record);

    Page<TEnergyData> findByPage(TEnergyData record);

    int findCount(TEnergyData record);

    List<TEnergyData> findByTime(@Param("beforeDay") String beforeDay,@Param("currDay") String currDay);

    RespEntity<Boolean> insertSelective(TEnergyData record);

    int insertSelf(TEnergyData record);

    int findOnlyOne(Map<String, Object> params);

    String sumEnergyUse(@Param("ikeys")List ikeys,
                            @Param("startTime")String startTime,
                            @Param("endTime")String endTime);
}




