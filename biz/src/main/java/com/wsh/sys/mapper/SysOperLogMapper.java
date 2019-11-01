package com.wsh.sys.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wsh.sys.domain.SysOperLog;

/**
 * 操作日志记录 数据层
 *
 * @author ruoyi
 * @date 2019-11-01
 */
public interface SysOperLogMapper extends BaseMapper<SysOperLog>
{
    /**
     * 新增操作日志
     * 
     * @param operLog 操作日志对象
     */
    public void insertOperlog(SysOperLog operLog);

}