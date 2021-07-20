package org.one.system.service;

import com.github.pagehelper.PageInfo;
import org.one.system.entity.Menu;
import xyz.icrab.common.service.BaseService;

import java.util.List;
import java.util.Map;

public interface MenuService {

    List<Menu> getListByUserId(Map<String, Object> maptoUserMenu);

    PageInfo<Menu> getPage(Menu menu);

    Menu getOneInParent(Map<String, Object> param);

    List<Menu> getlist();

    void deleteMenu(Menu menu);

    List<Menu> getList();

    int save(Menu menu);

    Menu get(String parentId);

    void update(Menu menu);
}
