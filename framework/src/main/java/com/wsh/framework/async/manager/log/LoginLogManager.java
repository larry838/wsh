package com.wsh.framework.async.manager.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsh.sys.domain.SysLoginLog;
import com.wsh.sys.service.SysLoginLogService;


@Service
public class LoginLogManager {
	@Autowired
    private SysLoginLogService loginLogService;
	
    /**
     * 新增系统登录日志
     * 
     * @param loginLog 访问日志对象
     */

    public void insertLoginLog(SysLoginLog loginLog){
		loginLogService.insertLoginLog(loginLog);
    }

}
