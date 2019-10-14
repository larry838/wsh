package com.wsh.sys.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.wsh.common.core.domain.BaseEntity;

import javax.persistence.*;
import lombok.Getter;
import lombok.Setter;

/**
 * 部门表 sys_dept
 * 
 * @author Carry xie
 */
@Getter
@Setter
@Table(name = "sys_dept")
public class SysDept extends BaseEntity {

	/***/
	private static final long serialVersionUID = 1L;

	/** 部门ID */
	@Id
	@Column(name = "dept_id")
	private Long deptId;

	/** 酒店ID */
	@Column(name = "hotel_id")
	private Long hotelId;

	/** 父部门ID */
	@Column(name = "parent_id")
	private Long parentId;

	/** 祖级列表 */
	@Column(name = "ancestors")
	private String ancestors;

	/** 部门名称 */
	@Column(name = "dept_name")
	private String deptName;

	/** 显示顺序 */
	@Column(name = "order_num")
	private String orderNum;

	/** 负责人 */
	private String leader;

	/** 联系电话 */
	private String phone;

	/** 邮箱 */
	private String email;

	/** 部门状态:0正常,-1停用 */
	private String status;

	/** 删除标志（0代表存在 -1代表删除） */
	@Column(name = "del_flag")
	private String delFlag;

	/** 父部门名称 */
	private String parentName;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("deptId", getDeptId())
            .append("hotelId",getHotelId())
            .append("parentId", getParentId())
            .append("ancestors", getAncestors())
            .append("deptName", getDeptName())
            .append("orderNum", getOrderNum())
            .append("leader", getLeader())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
