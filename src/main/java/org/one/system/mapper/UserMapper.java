package org.one.system.mapper;

import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.annotations.Mapper;
import org.one.system.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Mapper
public interface UserMapper  {
    List<User> infoPage(User user);

    User getOneAndRole(User user);

    List<String> getNickNames();

    List<String> getMobiles();

    User getUser(Map<String, Object> map);
}
