package com.wsh.system.mapper;

import java.util.List;
import com.wsh.system.domain.SysOperLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 操作日志记录 Mapper接口
 *
 * @author Carry xie
 * @date 2019-11-14
 */
 
public interface SysOperLogMapper extends BaseMapper<SysOperLog> {

    /**
     * 查询操作日志记录列表
     * 
     * @param sysOperLog 操作日志记录
     * @return 操作日志记录集合
     */
    public List<SysOperLog> selectSysOperLogList(SysOperLog sysOperLog);
}