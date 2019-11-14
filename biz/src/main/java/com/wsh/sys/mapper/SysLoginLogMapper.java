package com.wsh.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wsh.sys.domain.SysLoginLog;

/**
 * 系统访问记录 数据层
 *
 * @author Carry xie
 * @date 2019-11-01
 */
public interface SysLoginLogMapper extends BaseMapper<SysLoginLog>
{
    /**
     * 新增系统登录日志
     * 
     * @param loginLog 访问日志对象
     */
    public void insertLoginLog(SysLoginLog loginLog);
}