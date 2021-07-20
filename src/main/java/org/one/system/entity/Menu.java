package org.one.system.entity;


import org.one.common.base.BaseEntity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.ArrayList;
import java.util.List;

/**
 * 菜单表
 * @auther  周广
 */
@Table(name = "t_menu")
public class Menu extends BaseEntity {
    @Id
    private String id;

    /**
     * 菜单名
     */
    private String name;

    /**
     * 菜单编码
     */
    private String code;

    /**
     *  菜单地址
     */
    private String url;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 上级编码
     */
    private String parentId;

    /**
     * 上级名称
     */
    @Transient
    private String parentName;
    //    1菜单  2按钮
    private Integer type;
    //    启用状态 1-启用   2-禁用
    private Integer state;
    //层级
    private Integer floor;

    /**
     * 排序
     */
    private Integer sort;

    @Transient
    private List<Menu> children = new ArrayList<>();

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public List<Menu> getChildren() {
        return children;
    }

    public void setChildren(List<Menu> children) {
        this.children = children;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }
}
