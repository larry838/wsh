package com.wsh.sys.service.impl;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wsh.common.utils.StringUtils;
import com.wsh.sys.domain.SysRole;
import com.wsh.sys.mapper.SysRoleMapper;
import com.wsh.sys.service.SysRoleService;

@Service
public class SysRoleServiceImpl implements SysRoleService{
	
    @Autowired
    private SysRoleMapper roleMapper;
    
    /**
     * 根据用户ID查询权限
     * 
     * @param userId 用户ID
     * @return 权限列表
     */
    @Override
    public Set<String> selectRoleKeys(Long userId)
    {
        List<SysRole> perms = roleMapper.selectRolesByUserId(userId);
        Set<String> permsSet = new HashSet<>();
        for (SysRole perm : perms)
        {
            if (StringUtils.isNotNull(perm))
            {
                permsSet.addAll(Arrays.asList(perm.getRoleKey().trim().split(",")));
            }
        }
        return permsSet;
    }

}
