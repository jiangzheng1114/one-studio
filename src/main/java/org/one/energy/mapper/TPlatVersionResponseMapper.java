package org.one.energy.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.one.energy.entity.TCollectConfig;
import org.one.energy.entity.TPlatVersionResponse;

import java.util.Map;

@Mapper
public interface TPlatVersionResponseMapper {
    int deleteByPrimaryKey(String id);

    int insert(Map<String,Object> param);

    int insertSelective(Map<String,Object> param);

    TPlatVersionResponse selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TPlatVersionResponse record);

    int updateByPrimaryKey(TPlatVersionResponse record);

    Page<TPlatVersionResponse> findByPage(TPlatVersionResponse record);

    int findCount(TPlatVersionResponse record);
}