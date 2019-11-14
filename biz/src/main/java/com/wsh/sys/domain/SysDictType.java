package com.wsh.sys.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;


/**
 * 字典类型表 sys_dict_type
 *
 * @author Carry xie
 * @date 2019-11-14
 */
 
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_dict_type")
public class SysDictType implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 字典主键 */
  @TableId(value="dict_id", type= IdType.AUTO)
private Long dictId;
    
    /** 字典名称 */
  @TableField("dict_name")
private String dictName;
    
    /** 字典类型 */
  @TableField("dict_type")
private String dictType;
    
    /** 状态（0正常 1停用） */
private String status;
    
    /** 创建者 */
  @TableField("create_by")
private String createBy;
    
    /** 创建时间 */
  @TableField("create_time")
@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date createTime;
    
    /** 更新者 */
  @TableField("update_by")
private String updateBy;
    
    /** 更新时间 */
  @TableField("update_time")
@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date updateTime;
    
    /** 备注 */
private String remark;
    
}