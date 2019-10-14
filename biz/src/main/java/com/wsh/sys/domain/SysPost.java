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
 * 岗位表 sys_post
 * 
 * @author Carry xie
 */
@Getter
@Setter
@Table(name = "sys_post")
public class SysPost extends BaseEntity
{

    /***/
	private static final long serialVersionUID =1L;

	/** 岗位序号 */
    @Excel(name = "岗位序号")
    @Id
    @Column(name = "post_id")
    private Long postId;
    
    /** 岗位编码 */
    @Excel(name = "岗位编码")
    @Column(name = "post_code")
    private String postCode;

    /** 岗位名称 */
    @Excel(name = "岗位名称")
    @Column(name = "post_name")
    private String postName;

    /** 岗位排序 */
    @Excel(name = "岗位排序")
    @Column(name = "post_sort")
    private String postSort;

    /** 状态（0正常 -1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,-1=停用")
    private String status;
    
    /** 删除标志（0代表存在 -1代表删除） */
    @Column(name = "del_flag")
    private String delFlag;

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("postId", getPostId())
            .append("postCode", getPostCode())
            .append("postName", getPostName())
            .append("postSort", getPostSort())
            .append("status", getStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
