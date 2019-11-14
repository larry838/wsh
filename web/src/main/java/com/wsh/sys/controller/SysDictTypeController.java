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
import com.wsh.sys.domain.SysDictType;
import com.wsh.sys.service.SysDictTypeService;
import com.wsh.common.core.controller.BaseController;
import com.wsh.common.core.domain.AjaxResult;
import com.wsh.common.utils.poi.ExcelUtil;
import com.wsh.common.text.Convert;
import com.wsh.common.core.page.TableDataInfo;

/**
 * 字典类型Controller
 * 
 * @author Carry xie
 * @date 2019-11-14
 */
 
@Controller
@RequestMapping("/sys/type")
public class SysDictTypeController extends BaseController {

    private String prefix = "sys/type";

    @Autowired
    private SysDictTypeService sysDictTypeService;

    @RequiresPermissions("sys:type:view")
    @GetMapping()
    public String type()
    {
        return prefix + "/list";
    }

    /**
     * 查询字典类型列表
     */
    @RequiresPermissions("sys:type:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysDictType sysDictType)
    {
        startPage();
        return getDataTable(sysDictTypeService.list(new QueryWrapper<>()));
	/*
	 List<SysDictType> list = sysDictTypeService.selectSysDictTypeList(sysDictType);
        return getDataTable(list);
	*/
    }

    /**
     * 导出字典类型列表
     */
    @RequiresPermissions("sys:type:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysDictType sysDictType)
    {
        List<SysDictType> list = sysDictTypeService.list(new QueryWrapper<>());
        //List<SysDictType> list = sysDictTypeService.selectSysDictTypeList(sysDictType);
        ExcelUtil<SysDictType> util = new ExcelUtil<SysDictType>(SysDictType.class);
        return util.exportExcel(list, "type");
    }

    /**
     * 新增字典类型
     */
    @GetMapping("/add")
    public String add()
    {
        return prefix + "/add";
    }

    /**
     * 新增保存字典类型
     */
    @RequiresPermissions("sys:type:add")
    @SysLog(title = "字典类型", businessType = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysDictType sysDictType)
    {
        return toAjax(sysDictTypeService.save(sysDictType));
	//return toAjax(sysDictTypeService.insertSysDictType(sysDictType));
    }

    /**
     * 修改字典类型
     */
    @GetMapping("/edit/{dictId}")
    public String edit(@PathVariable("dictId") Long dictId, ModelMap mmap)
    {
        SysDictType sysDictType = sysDictTypeService.getById(dictId);
	//SysDictType sysDictType = sysDictTypeService.selectSysDictTypeById(dictId);
        mmap.put("sysDictType", sysDictType);
        return prefix + "/edit";
    }

    /**
     * 修改保存字典类型
     */
    @RequiresPermissions("sys:type:edit")
    @SysLog(title = "字典类型", businessType = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysDictType sysDictType)
    {
        return toAjax(sysDictTypeService.updateById(sysDictType));
	//return toAjax(sysDictTypeService.updateSysDictType(sysDictType));
    }

    /**
     * 删除字典类型
     */
    @RequiresPermissions("sys:type:remove")
    @SysLog(title = "字典类型", businessType = BusinessType.DELETE)
    @PostMapping( "/remove")
    @ResponseBody
    public AjaxResult remove(String ids)
    {
        return toAjax(sysDictTypeService.removeByIds(Arrays.asList(Convert.toStrArray(ids))));
	//return toAjax(sysDictTypeService.deleteSysDictTypeByIds(ids));
    }
    
    /**
     * 校验字典类型
     */
    @PostMapping("/checkDictTypeUnique")
    @ResponseBody
    public String checkDictTypeUnique(SysDictType dictType)
    {
        return sysDictTypeService.checkDictTypeUnique(dictType);
    }

}
