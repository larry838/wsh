package com.wsh.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wsh.common.core.domain.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
  
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;


/**
 * 操作日志记录表 sys_oper_log
 *
 * @author Carry xie
 * @date 2019-11-14
 */
 
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_oper_log")
public class SysOperLog  implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 日志主键 */
  @TableId(value="oper_id", type= IdType.AUTO)
private Long operId;
    
    /** 模块标题 */
private String title;
    
    /** 业务类型（0其它 1新增 2修改 3删除） */
  @TableField("business_type")
private Integer businessType;
    
    /** 方法名称 */
private String method;
    
    /** 操作类别（0其它 1后台用户 2手机端用户） */
  @TableField("operator_type")
private Integer operatorType;
    
    /** 操作人员 */
  @TableField("oper_name")
private String operName;
    
    /** 部门名称 */
  @TableField("dept_name")
private String deptName;
    
    /** 请求URL */
  @TableField("oper_url")
private String operUrl;
    
    /** 主机地址 */
  @TableField("oper_ip")
private String operIp;
    
    /** 操作地点 */
  @TableField("oper_location")
private String operLocation;
    
    /** 请求参数 */
  @TableField("oper_param")
private String operParam;
    
    /** 操作状态（0正常 1异常） */
private Integer status;
    
    /** 错误消息 */
  @TableField("error_msg")
private String errorMsg;
    
    /** 操作时间 */
  @TableField("oper_time")
@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
private Date operTime;
    
}