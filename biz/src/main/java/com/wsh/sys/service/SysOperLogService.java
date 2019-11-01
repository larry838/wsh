package com.wsh.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.wsh.sys.domain.SysOperLog;

/**
 * 操作日志记录 服务层
 *
 * @author ruoyi
 * @date 2019-11-01
 */
public interface SysOperLogService extends IService<SysOperLog>
{
    /**
     * 新增操作日志
     * 
     * @param operLog 操作日志对象
     */
    public void insertOperlog(SysOperLog operLog);
}