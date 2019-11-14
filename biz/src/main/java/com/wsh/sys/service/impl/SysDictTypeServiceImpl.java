package com.wsh.sys.service.impl;

import java.util.ArrayList;
import java.util.List;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.wsh.sys.mapper.SysDictTypeMapper;
import com.wsh.common.constant.SysConstants;
import com.wsh.common.core.domain.Ztree;
import com.wsh.common.utils.StringUtils;
import com.wsh.sys.domain.SysDictType;
import com.wsh.sys.service.SysDictTypeService;

/**
 * 字典类型 Service业务层实现
 *
 * @author Carry xie
 * @date 2019-11-14
 */
 
@Service
public class SysDictTypeServiceImpl extends ServiceImpl<SysDictTypeMapper, SysDictType> implements SysDictTypeService {
   
    @Autowired
    private SysDictTypeMapper sysDictTypeMapper;

    /**
     * 查询字典类型列表
     * 
     * @param sysDictType 字典类型
     * @return 字典类型
     */
    @Override
    public List<SysDictType> selectSysDictTypeList(SysDictType sysDictType)
    {
        return sysDictTypeMapper.selectSysDictTypeList(sysDictType);
    }
    
    /**
     * 校验字典类型称是否唯一
     * 
     * @param dict 字典类型
     * @return 结果
     */
    @Override
    public String checkDictTypeUnique(SysDictType dict)
    {
        Long dictId = StringUtils.isNull(dict.getDictId()) ? -1L : dict.getDictId();
        SysDictType dictType = sysDictTypeMapper.checkDictTypeUnique(dict.getDictType());
        if (StringUtils.isNotNull(dictType) && dictType.getDictId().longValue() != dictId.longValue())
        {
            return SysConstants.DICT_TYPE_NOT_UNIQUE;
        }
        return SysConstants.DICT_TYPE_UNIQUE;
    }

    /**
     * 查询字典类型树
     * 
     * @param dictType 字典类型
     * @return 所有字典类型
     */
    public List<Ztree> selectDictTree(SysDictType dictType)
    {
        List<Ztree> ztrees = new ArrayList<Ztree>();
        List<SysDictType> dictList = sysDictTypeMapper.selectSysDictTypeList(dictType);
        for (SysDictType dict : dictList)
        {
            if (SysConstants.DICT_NORMAL.equals(dict.getStatus()))
            {
                Ztree ztree = new Ztree();
                ztree.setId(dict.getDictId());
                ztree.setName(transDictName(dict));
                ztree.setTitle(dict.getDictType());
                ztrees.add(ztree);
            }
        }
        return ztrees;
    }
    
    private String transDictName(SysDictType dictType)
    {
        StringBuffer sb = new StringBuffer();
        sb.append("(" + dictType.getDictName() + ")");
        sb.append("&nbsp;&nbsp;&nbsp;" + dictType.getDictType());
        return sb.toString();
    }
}