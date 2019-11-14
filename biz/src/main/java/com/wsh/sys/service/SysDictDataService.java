package com.wsh.sys.service;

import com.wsh.sys.domain.SysDictData;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * 字典数据 Service接口
 *
 * @author Carry xie
 * @date 2019-11-14
 */
 
public interface SysDictDataService extends IService<SysDictData> {

    /**
     * 查询字典数据列表
     * 
     * @param sysDictData 字典数据
     * @return 字典数据集合
     */
    public List<SysDictData> selectSysDictDataList(SysDictData sysDictData);
    
    /**
     * 根据字典类型查询字典数据
     * 
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    public List<SysDictData> selectDictDataByType(String dictType);
    
    /**
     * 根据字典类型和字典键值查询字典数据信息
     * 
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    public String selectDictLabel(String dictType, String dictValue);
}