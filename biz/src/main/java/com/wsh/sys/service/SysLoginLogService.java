package com.wsh.sys.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.wsh.sys.domain.SysLoginLog;

/**
 * 系统访问记录 服务层
 *
 * @author ruoyi
 * @date 2019-11-01
 */
public interface SysLoginLogService extends IService<SysLoginLog>
{
    /**
     * 新增系统登录日志
     * 
     * @param loginLog 访问日志对象
     */
    public void insertLoginLog(SysLoginLog loginLog);

}