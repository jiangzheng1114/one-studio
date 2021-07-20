package org.one.system.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.one.system.entity.User;
import org.one.system.mapper.UserMapper;
import org.one.system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.icrab.common.model.Pageable;
import xyz.icrab.common.model.Pagination;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    
    @Autowired
    private UserMapper userMapper;
    
    @Override
    public PageInfo<User> getPage(User user) {
        PageHelper.startPage(user.getPage(), user.getLimit());
        return new PageInfo<>(userMapper.infoPage(user));
    }

    @Override
    public User getOneAndRole(User user) {
        return userMapper.getOneAndRole(user);
    }

    @Override
    public List<String> getNickNames() {
        return userMapper.getNickNames();
    }

    @Override
    public List<String> getMobiles() {
        return userMapper.getMobiles();
    }


    @Override
    public User getUser(Map<String, Object> map) {
        return userMapper.getUser(map);
    }
}
