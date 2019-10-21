package com.wsh.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.wsh.common.config.Global;
import com.wsh.common.core.controller.BaseController;


/**
 *  首页 业务处理
 *  
 * @author Carry xie
 *
 */
@Controller
public class SysIndexController extends BaseController
{
	  // 系统首页
	@GetMapping(value = { "","/","/index" })
    public String index(ModelMap mmap){
    	return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap)
    {
        mmap.put("version", Global.getVersion());
        return "main";
    }

}
