package org.one.system.mapper;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageRowBounds;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.one.system.entity.Menu;

import java.util.List;
import java.util.Map;
@Mapper
public interface MenuMapper {
    List<Menu> getListByUserId(Map<String, Object> maptoUserMenu);

    Page<Menu> getPage(Menu menu/*, @Param("currPage")int currPage,@Param("pageSize")int pageSize*/);

    Menu getOneInParent(Map<String, Object> param);

    List<Menu> getList();

    List<Menu> infoUserPage(Map<String, Object> param, PageRowBounds rowBounds);

    int findCount(Menu menu);

    void deleteMenuById(Menu menu);

    int save(Menu menu);

    Menu get(String parentId);

    void update(Menu menu);
}
