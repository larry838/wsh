package com.wsh.sys.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wsh.common.annotation.Excel;
import com.wsh.common.core.domain.BaseEntity;

import lombok.Getter;
import lombok.Setter;

/**
 * 系统访问记录表 sys_login_log
 * 
 * author Carry xie
 */
@Getter
@Setter
@Table(name = "sys_login_log")
public class SysLoginLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    
    /** ID */
    @Excel(name = "序号")
    @Id
    @Column(name = "log_id")
    private Long logId;
    
    /** 用户账号 */
    @Excel(name = "用户账号")
    @Column(name = "login_name")
    private String loginName;
    
    /** 登录状态 0成功 1失败 */
    @Excel(name = "登录状态", readConverterExp = "0=成功,1=失败")
    private String status;
    
    /** 登录IP地址 */
    @Excel(name = "登录地址")
    @Column(name = "ip_address")
    private String ipAddress;
    
    /** 登录地点 */
    @Excel(name = "登录地点")
    @Column(name = "login_location")
    private String loginLocation;
    
    /** 浏览器类型 */
    @Excel(name = "浏览器")
    private String browser;
    
    /** 操作系统 */
    @Excel(name = "操作系统 ")
    private String os;
    
    /** 提示消息 */
    @Excel(name = "提示消息")
    private String msg;
    
    /** 访问时间 */
    @Excel(name = "访问时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    @Column(name = "login_time")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date loginTime;


    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("infoId", getLogId())
            .append("loginName", getLoginName())
            .append("ipAddress", getIpAddress())
            .append("loginLocation", getLoginLocation())
            .append("browser", getBrowser())
            .append("os", getOs())
            .append("status", getStatus())
            .append("msg", getMsg())
            .append("loginTime", getLoginTime())
            .toString();
    }
}