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
import com.wsh.common.annotation.SysLog;
import com.wsh.common.core.controller.BaseController;
import com.wsh.common.core.domain.AjaxResult;
import com.wsh.common.core.page.TableDataInfo;
import com.wsh.common.enums.BusinessType;
import com.wsh.common.text.Convert;
import com.wsh.common.utils.poi.ExcelUtil;
import com.wsh.sys.domain.SysOperLog;
import com.wsh.sys.service.SysOperLogService;

/**
 * 操作日志记录Controller
 * 
 * @author ruoyi
 * @date 2019-11-01
 */
@Controller
@RequestMapping("/operlog")
public class SysOperLogController extends BaseController
{
    private String prefix = "operlog";

    @Autowired
    private SysOperLogService sysOperLogService;

    @RequiresPermissions("operlog:view")
    @GetMapping()
    public String log()
    {
        return prefix + "/log";
    }

    /**
     * 查询操作日志记录列表
     */
    @RequiresPermissions("operlog:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysOperLog sysOperLog)
    {
        startPage();
        return getDataTable(sysOperLogService.list(new QueryWrapper<>()));
    }

    /**
     * 导出操作日志记录列表
     */
    @RequiresPermissions("operlog:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysOperLog sysOperLog)
    {
        List<SysOperLog> list = sysOperLogService.list(new QueryWrapper<>());
        ExcelUtil<SysOperLog> util = new ExcelUtil<SysOperLog>(SysOperLog.class);
        return util.exportExcel(list, "log");
    }

    /**
     * 新增操作日志记录
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存操作日志记录
     */
    @RequiresPermissions("operlog:add")
    @SysLog(title = "操作日志记录", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysOperLog sysOperLog)
    {
        return toAjax(sysOperLogService.save(sysOperLog));
    }

    /**
     * 修改操作日志记录
     */
    @GetMapping("/edit/{operId}")
    public String edit(@PathVariable("operId") Long operId, ModelMap mmap)
    {
        SysOperLog sysOperLog = sysOperLogService.getById(operId);
        mmap.put("sysOperLog", sysOperLog);
        return prefix + "/edit";
    }

    /**
     * 修改保存操作日志记录
     */
    @RequiresPermissions("operlog:edit")
    @SysLog(title = "操作日志记录", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysOperLog sysOperLog)
    {
        return toAjax(sysOperLogService.updateById(sysOperLog));
    }

    /**
     * 删除操作日志记录
     */
    @RequiresPermissions("operlog:remove")
    @SysLog(title = "操作日志记录", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysOperLogService.removeByIds(Arrays.asList(Convert.toStrArray(ids))));
    }
}
