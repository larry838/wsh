package com.wsh.sys.mapper;

import java.util.List;
import com.wsh.sys.domain.SysDictType;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * 字典类型 Mapper接口
 *
 * @author Carry xie
 * @date 2019-11-14
 */
 
public interface SysDictTypeMapper extends BaseMapper<SysDictType> {

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
    public SysDictType checkDictTypeUnique(String dictType);
}