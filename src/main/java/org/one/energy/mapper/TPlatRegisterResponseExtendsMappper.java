package org.one.energy.mapper;

import com.github.pagehelper.Page;
import org.apache.ibatis.annotations.Mapper;
import org.one.energy.entity.BCollectItem;
import org.one.energy.entity.TPlatRegisterResponseExtendsEntity;

import java.util.List;

@Mapper
public interface TPlatRegisterResponseExtendsMappper {

    Page<TPlatRegisterResponseExtendsEntity> findByPage(TPlatRegisterResponseExtendsEntity record);

    int findCount(TPlatRegisterResponseExtendsEntity record);
}
