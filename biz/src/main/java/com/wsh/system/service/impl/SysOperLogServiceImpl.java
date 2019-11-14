package com.wsh.system.service.impl;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wsh.system.mapper.SysOperLogMapper;
import com.wsh.system.domain.SysOperLog;
import com.wsh.system.service.SysOperLogService;

/**
 * 操作日志记录 Service业务层实现
 *
 * @author Carry xie
 * @date 2019-11-14
 */
 
@Service
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLog> implements SysOperLogService {
   
    @Autowired
    private SysOperLogMapper sysOperLogMapper;

    /**
     * 查询操作日志记录列表
     * 
     * @param sysOperLog 操作日志记录
     * @return 操作日志记录
     */
    @Override
    public List<SysOperLog> selectSysOperLogList(SysOperLog sysOperLog)
    {
        return sysOperLogMapper.selectSysOperLogList(sysOperLog);
    }
}