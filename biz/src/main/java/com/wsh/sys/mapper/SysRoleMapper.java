package com.wsh.sys.mapper;

import java.util.List;

import com.wsh.sys.domain.SysRole;

/**
 * 角色表 数据层
 * 
 * @author Carry xie
 */
public interface SysRoleMapper {
	
    /**
     * 根据用户ID查询角色
     * 
     * @param userId 用户ID
     * @return 角色列表
     */
    public List<SysRole> selectRolesByUserId(Long userId);

}
