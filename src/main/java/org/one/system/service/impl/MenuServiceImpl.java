package org.one.system.service.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.one.system.entity.Menu;
import org.one.system.mapper.MenuMapper;
import org.one.system.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<Menu> getListByUserId(Map<String, Object> maptoUserMenu) {
        return menuMapper.getListByUserId(maptoUserMenu);
    }

    @Override
    public PageInfo<Menu> getPage(Menu menu) {
        PageHelper.startPage(menu.getPage(), menu.getLimit());
        PageInfo<Menu> menuPageInfo = new PageInfo<>(menuMapper.getPage(menu));
        menuPageInfo.setSize(menuMapper.findCount(menu));
        return menuPageInfo;
    }

    @Override
    public Menu getOneInParent(Map<String, Object> param) {
        return menuMapper.getOneInParent(param);
    }

    @Override
    public List<Menu> getlist() {
        return menuMapper.getList();
    }

    @Override
    public void deleteMenu(Menu menu) {
        menuMapper.deleteMenuById(menu);
    }

    @Override
    public List<Menu> getList() {
        return menuMapper.getList();
    }

    @Override
    public int save(Menu menu) {
        return menuMapper.save(menu);
    }

    @Override
    public Menu get(String parentId) {
        return menuMapper.get(parentId);
    }

    @Override
    public void update(Menu menu) {
        menuMapper.update(menu);
    }
}
