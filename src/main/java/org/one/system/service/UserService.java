package org.one.system.service;

import com.github.pagehelper.PageInfo;
import org.one.system.entity.User;
import xyz.icrab.common.model.Pageable;
import xyz.icrab.common.model.Pagination;
import xyz.icrab.common.service.BaseService;

import java.util.List;
import java.util.Map;

public interface UserService  {
    PageInfo<User> getPage(User user);

    User getOneAndRole(User user);

    List<String> getNickNames();

    List<String> getMobiles();

    User getUser(Map<String, Object> map);
}
