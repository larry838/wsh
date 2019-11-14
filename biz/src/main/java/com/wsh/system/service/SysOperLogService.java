package com.wsh.system.service;

import com.wsh.system.domain.SysOperLog;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 操作日志记录 Service接口
 *
 * @author Carry xie
 * @date 2019-11-14
 */
 
public interface SysOperLogService extends IService<SysOperLog> {

    /**
     * 查询操作日志记录列表
     * 
     * @param sysOperLog 操作日志记录
     * @return 操作日志记录集合
     */
    public List<SysOperLog> selectSysOperLogList(SysOperLog sysOperLog);
}