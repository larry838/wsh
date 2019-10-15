package com.wsh.framework.async.manager.log;

import org.springframework.stereotype.Service;

import com.wsh.sys.domain.SysLoginLog;


@Service
public class LoginLogManager {
	
  //  private SysLoginLogService loginLogService;
	
    /**
     * 新增系统登录日志
     * 
     * @param loginLog 访问日志对象
     */

    public void insertLoginLog(SysLoginLog loginLog){
		//loginLogService.insertLoginLog(loginLog);
    }

}
