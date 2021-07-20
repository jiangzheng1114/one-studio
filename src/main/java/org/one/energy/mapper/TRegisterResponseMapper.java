package org.one.energy.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.one.energy.entity.TRegisterResponse;

import java.util.List;
import java.util.Map;
@Mapper
public interface TRegisterResponseMapper {
    int deleteByPrimaryKey(String id);

    int insert(TRegisterResponse tRegisterResponse);

    int insertSelective(TRegisterResponse tRegisterResponse);

    TRegisterResponse selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TRegisterResponse record);

    int updateByPrimaryKey(TRegisterResponse record);

    List<TRegisterResponse> select();

    Page<TRegisterResponse> findByPage(TRegisterResponse record);

    int findCount(TRegisterResponse record);

    /**
     * 查询注册码deviceId
     * @return
     */
    TRegisterResponse selectDeviceId();
}