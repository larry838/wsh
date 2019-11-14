package com.wsh.sys.service.impl;

import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wsh.sys.mapper.SysDictDataMapper;
import com.wsh.sys.domain.SysDictData;
import com.wsh.sys.service.SysDictDataService;

/**
 * 字典数据 Service业务层实现
 *
 * @author Carry xie
 * @date 2019-11-14
 */
 
@Service
public class SysDictDataServiceImpl extends ServiceImpl<SysDictDataMapper, SysDictData> implements SysDictDataService {
   
    @Autowired
    private SysDictDataMapper sysDictDataMapper;

    /**
     * 查询字典数据列表
     * 
     * @param sysDictData 字典数据
     * @return 字典数据
     */
    @Override
    public List<SysDictData> selectSysDictDataList(SysDictData sysDictData)
    {
        return sysDictDataMapper.selectSysDictDataList(sysDictData);
    }
    
    /**
     * 根据字典类型查询字典数据
     * 
     * @param dictType 字典类型
     * @return 字典数据集合信息
     */
    @Override
    public List<SysDictData> selectDictDataByType(String dictType)
    {
        return sysDictDataMapper.selectDictDataByType(dictType);
    }
    
    /**
     * 根据字典类型和字典键值查询字典数据信息
     * 
     * @param dictType 字典类型
     * @param dictValue 字典键值
     * @return 字典标签
     */
    @Override
    public String selectDictLabel(String dictType, String dictValue)
    {
        return sysDictDataMapper.selectDictLabel(dictType, dictValue);
    }
    
}