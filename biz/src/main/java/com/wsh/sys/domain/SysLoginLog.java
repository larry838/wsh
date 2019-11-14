package com.wsh.sys.domain;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
                                    
/**
 * 系统访问记录表 sys_login_log
 *
 * @author Carry xie
 * @date 2019-11-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sys_login_log")
public class SysLoginLog  implements Serializable
        {
private static final long serialVersionUID = 1L;

/** 访问ID */
private Long logId;
/** 登录账号 */
private String loginName;
/** 登录IP地址 */
private String ipAddress;
/** 登录地点 */
private String loginLocation;
/** 浏览器类型 */
private String browser;
/** 操作系统 */
private String os;
/** 登录状态（0成功 1失败） */
private String status;
/** 提示消息 */
private String msg;
/** 访问时间 */
private Date loginTime;
}