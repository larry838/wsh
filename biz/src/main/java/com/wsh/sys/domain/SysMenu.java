package com.wsh.sys.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.wsh.common.core.domain.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 菜单权限表 sys_menu
 * 
 * @author Carry xie
 */
@Getter
@Setter
@Table(name = "sys_menu")
public class SysMenu extends BaseEntity
{

    /***/
	private static final long serialVersionUID = 1L;

	/** 菜单ID */
	@Id
    @Column(name = "menu_id")
    private Long menuId;

    /** 菜单名称 */
	@Column(name = "menu_name")
    private String menuName;

    /** 父菜单名称 */
    private String parentName;

    /** 父菜单ID */
    @Column(name = "parent_id")
    private Long parentId;

    /** 显示顺序 */
    @Column(name = "order_num")
    private String orderNum;

    /** 菜单URL */
    private String url;

    /** 打开方式：menuItem页签 menuBlank新窗口 */
    private String target;

    /** 类型:0目录,1菜单,2按钮 */
    @Column(name = "menu_type")
    private String menuType;

    /** 菜单状态:0显示,1隐藏 */
    private String visible;

    /** 权限编码 */
    @Column(name = "permission_code")
    private String permissionCode;

    /** 菜单图标 */
    private String icon;

    /** 子菜单 */
    private List<SysMenu> children = new ArrayList<SysMenu>();
    

    public List<SysMenu> getChildren()
    {
        return children;
    }

    public void setChildren(List<SysMenu> children)
    {
        this.children = children;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("menuId", getMenuId())
            .append("menuName", getMenuName())
            .append("parentId", getParentId())
            .append("orderNum", getOrderNum())
            .append("url", getUrl())
            .append("target", getTarget())
            .append("menuType", getMenuType())
            .append("visible", getVisible())
            .append("permissionCode", getPermissionCode())
            .append("icon", getIcon())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
