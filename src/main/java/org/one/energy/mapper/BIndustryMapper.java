package org.one.energy.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.one.energy.entity.BIndustry;

import java.util.List;

/**
 * @Entity org.one.energy.entity.BIndustry
 */
@Mapper
public interface BIndustryMapper {

    int deleteByPrimaryKey(String code);

    int insert(BIndustry record);

    int insertSelective(BIndustry record);

    BIndustry selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(BIndustry record);

    int updateByPrimaryKey(BIndustry record);

    Page<BIndustry> findByPage(BIndustry record);

    //获取除门业大类（pcode!=1）以外的数据
    List<BIndustry> load();
}




