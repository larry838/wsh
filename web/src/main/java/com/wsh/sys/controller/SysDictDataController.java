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
import com.wsh.common.enums.BusinessType;
import com.wsh.sys.domain.SysDictData;
import com.wsh.sys.service.SysDictDataService;
import com.wsh.common.core.controller.BaseController;
import com.wsh.common.core.domain.AjaxResult;
import com.wsh.common.utils.poi.ExcelUtil;
import com.wsh.common.text.Convert;
import com.wsh.common.core.page.TableDataInfo;

/**
 * 字典数据Controller
 * 
 * @author Carry xie
 * @date 2019-11-14
 */
 
@Controller
@RequestMapping("/sys/data")
public class SysDictDataController extends BaseController {

    private String prefix = "sys/data";

    @Autowired
    private SysDictDataService sysDictDataService;

    @RequiresPermissions("sys:data:view")
    @GetMapping()
    public String data()
    {
        return prefix + "/list";
    }

    /**
     * 查询字典数据列表
     */
    @RequiresPermissions("sys:data:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysDictData sysDictData)
    {
        startPage();
       // return getDataTable(sysDictDataService.list(new QueryWrapper<>()));
	
	    List<SysDictData> list = sysDictDataService.selectSysDictDataList(sysDictData);
        return getDataTable(list);
	
    }

    /**
     * 导出字典数据列表
     */
    @RequiresPermissions("sys:data:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysDictData sysDictData)
    {
        List<SysDictData> list = sysDictDataService.list(new QueryWrapper<>());
        //List<SysDictData> list = sysDictDataService.selectSysDictDataList(sysDictData);
        ExcelUtil<SysDictData> util = new ExcelUtil<SysDictData>(SysDictData.class);
        return util.exportExcel(list, "data");
    }

    /**
     * 新增字典数据
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存字典数据
     */
    @RequiresPermissions("sys:data:add")
    @SysLog(title = "字典数据", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysDictData sysDictData)
    {
        return toAjax(sysDictDataService.save(sysDictData));
	//return toAjax(sysDictDataService.insertSysDictData(sysDictData));
    }

    /**
     * 修改字典数据
     */
    @GetMapping("/edit/{dictCode}")
    public String edit(@PathVariable("dictCode") Long dictCode, ModelMap mmap)
    {
        SysDictData sysDictData = sysDictDataService.getById(dictCode);
	//SysDictData sysDictData = sysDictDataService.selectSysDictDataById(dictCode);
        mmap.put("sysDictData", sysDictData);
        return prefix + "/edit";
    }

    /**
     * 修改保存字典数据
     */
    @RequiresPermissions("sys:data:edit")
    @SysLog(title = "字典数据", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysDictData sysDictData)
    {
        return toAjax(sysDictDataService.updateById(sysDictData));
	//return toAjax(sysDictDataService.updateSysDictData(sysDictData));
    }

    /**
     * 删除字典数据
     */
    @RequiresPermissions("sys:data:remove")
    @SysLog(title = "字典数据", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysDictDataService.removeByIds(Arrays.asList(Convert.toStrArray(ids))));
	//return toAjax(sysDictDataService.deleteSysDictDataByIds(ids));
    }
}
