package org.one.energy.service.impl;

import org.one.energy.entity.TIrealdata;
import org.one.energy.mapper.TIrealdataMapper;
import org.one.energy.service.TIrealdataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TIrealdataServiceImpl implements TIrealdataService {

    @Autowired
    private TIrealdataMapper tIrealdataMapper;

    @Override
    public List<TIrealdata> selectAll() {
        return tIrealdataMapper.selectAll();
    }
}
