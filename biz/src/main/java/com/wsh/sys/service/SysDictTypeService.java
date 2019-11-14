package com.wsh.sys.service;

import com.wsh.common.core.domain.Ztree;
import com.wsh.sys.domain.SysDictType;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 字典类型 Service接口
 *
 * @author Carry xie
 * @date 2019-11-14
 */
 
public interface SysDictTypeService extends IService<SysDictType> {

    /**
     * 查询字典类型列表
     * 
     * @param sysDictType 字典类型
     * @return 字典类型集合
     */
    public List<SysDictType> selectSysDictTypeList(SysDictType sysDictType);
    
    
    /**
     * 校验字典类型称是否唯一
     * 
     * @param dictType 字典类型
     * @return 结果
     */
    public String checkDictTypeUnique(SysDictType dictType);

    /**
     * 查询字典类型树
     * 
     * @param dictType 字典类型
     * @return 所有字典类型
     */
    public List<Ztree> selectDictTree(SysDictType dictType);
}