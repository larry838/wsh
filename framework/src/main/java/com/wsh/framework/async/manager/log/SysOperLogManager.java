package com.wsh.framework.async.manager.log;


import org.springframework.stereotype.Service;

import com.wsh.sys.domain.SysOperLog;



@Service
public class SysOperLogManager {

	//@Reference(version = "${dubbo.consumer.version}")
   // private SysOperLogService operLogService;
	
	
	
    /**
     * 新增操作日志
     * 
     * @param operLog 操作日志对象
     */
    public void insertOperlog(SysOperLog operLog){
    	//operLogService.insertOperlog(operLog);
    }
}
