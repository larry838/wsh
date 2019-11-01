package com.wsh.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wsh.sys.domain.SysLoginLog;
import com.wsh.sys.mapper.SysLoginLogMapper;
import com.wsh.sys.service.SysLoginLogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 系统访问记录 服务层实现
 *
 * @author ruoyi
 * @date 2019-11-01
 */
@Service
public class SysLogininforServiceImpl extends ServiceImpl<SysLoginLogMapper, SysLoginLog> implements SysLoginLogService
{
    @Autowired
    private SysLoginLogMapper loginLogMapper;

    /**
     * 新增系统登录日志
     * 
     * @param loginLog 访问日志对象
     */
    @Override
    public void insertLoginLog(SysLoginLog loginLog)
    {
        loginLogMapper.insertLoginLog(loginLog);
    }
}