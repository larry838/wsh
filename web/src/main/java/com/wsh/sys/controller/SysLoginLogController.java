package com.wsh.sys.controller;

import java.util.Arrays;
import java.util.List;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.wsh.common.annotation.SysLog;
import com.wsh.common.core.controller.BaseController;
import com.wsh.common.core.domain.AjaxResult;
import com.wsh.common.core.domain.ResultInfo;
import com.wsh.common.enums.BusinessType;
import com.wsh.common.text.Convert;
import com.wsh.common.utils.poi.ExcelUtil;
import com.wsh.sys.domain.SysLoginLog;
import com.wsh.sys.service.SysLoginLogService;


/**
 * 系统访问记录Controller
 * 
 * @author Carry xie
 * @date 2019-11-01
 */
@Controller
@RequestMapping("/loginLog")
public class SysLoginLogController extends BaseController
{
    private String prefix = "loginlog";

    @Autowired
    private SysLoginLogService sysLoginLogService;

    @RequiresPermissions("loginLog:view")
    @GetMapping("/view")
    public String logininfor()
    {
        return prefix + "/list";
    }

    /**
     * 查询系统访问记录列表
     */
    @RequiresPermissions("loginLog:list")
    @RequestMapping("/list")
    @ResponseBody
    public ResultInfo<List<SysLoginLog>> listData(SysLoginLog sysLoginLog, Page page){
    	IPage<SysLoginLog> pageObj = (IPage<SysLoginLog>) sysLoginLogService.page(page, Wrappers.query(sysLoginLog));
    	return new ResultInfo<>(pageObj.getRecords(),pageObj.getTotal());
    }
    
    
    /**
     * 导出系统访问记录列表
     */
    @RequiresPermissions("loginLog:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysLoginLog sysLogininfor)
    {
        List<SysLoginLog> list = sysLoginLogService.list(new QueryWrapper<>());
        ExcelUtil<SysLoginLog> util = new ExcelUtil<SysLoginLog>(SysLoginLog.class);
        return util.exportExcel(list, "loginLog");
    }

    /**
     * 新增系统访问记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存系统访问记录
     */
    @RequiresPermissions("loginLog:add")
    @SysLog(title = "系统访问记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysLoginLog sysLogininfor)
    {
        return toAjax(sysLoginLogService.save(sysLogininfor));
    }

    /**
     * 修改系统访问记录
     */
    @GetMapping("/edit/{logId}")
    public String edit(@PathVariable("logId") Long logId, ModelMap mmap)
    {
        SysLoginLog sysLogininfor = sysLoginLogService.getById(logId);
        mmap.put("sysLoginLog", sysLogininfor);
        return prefix + "/edit";
    }

    /**
     * 修改保存系统访问记录
     */
    @RequiresPermissions("loginLog:edit")
    @SysLog(title = "系统访问记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysLoginLog sysLogininfor)
    {
        return toAjax(sysLoginLogService.updateById(sysLogininfor));
    }

    /**
     * 删除系统访问记录
     */
    @RequiresPermissions("loginLog:remove")
    @SysLog(title = "系统访问记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysLoginLogService.removeByIds(Arrays.asList(Convert.toStrArray(ids))));
    }
}
