package com.wsh.sys.domain;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.wsh.common.annotation.Excel;
import com.wsh.common.core.domain.BaseEntity;

import lombok.Getter;
import lombok.Setter;



/**
 * 角色表 sys_role
 * 
 * @author Carry xie
 */
@Getter
@Setter
@Table(name = "sys_role")
public class SysRole extends BaseEntity
{

    /***/
	private static final long serialVersionUID =1L;

	/** 角色ID */
    @Excel(name = "角色序号")
    @Id
    @Column(name = "role_id")
    private Long roleId;
    
    /** 角色名称 */
    @Excel(name = "角色名称")
    @Column(name = "role_name")
    private String roleName;

    /** 角色权限 */
    @Excel(name = "角色权限")
    @Column(name = "role_key")
    private String roleKey;

    /** 角色排序 */
    @Excel(name = "角色排序")
    @Column(name = "role_sort")
    private String roleSort;

    /** 数据范围（1：所有数据权限；2：自定数据权限） */
    @Excel(name = "数据范围", readConverterExp = "1=所有数据权限,2=自定义数据权限")
    @Column(name = "data_scope")
    private String dataScope;

    /** 角色状态（0正常 -1停用） */
    @Excel(name = "角色状态", readConverterExp = "0=正常,-1=停用")
    private String status;

    /** 删除标志（0代表存在 -1代表删除） */
    @Column(name = "del_flag")
    private String delFlag;

    /** 菜单组 */
    private Long[] menuIds;

    /** 部门组（数据权限） */
    private Long[] deptIds;

    /** 用户是否存在此角色标识 默认不存在 */
    private boolean flag = false;
    
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("roleId", getRoleId())
            .append("roleName", getRoleName())
            .append("roleKey", getRoleKey())
            .append("roleSort", getRoleSort())
            .append("dataScope", getDataScope())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
