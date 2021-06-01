package org.one.energy.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.one.energy.entity.BProc;

import java.util.List;

/**
 * @Entity org.one.energy.entity.BProc
 */
@Mapper
public interface BProcMapper {

    int deleteByPrimaryKey(String id);

    int insert(BProc record);

    int insertSelective(BProc record);

    BProc selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(BProc record);

    int updateByPrimaryKey(BProc record);

    List<BProc> load();

    int insertTProc(BProc record);

    void truncateTProc();

}




