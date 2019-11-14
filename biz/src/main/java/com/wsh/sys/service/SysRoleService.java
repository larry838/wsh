package com.wsh.sys.service;

import java.util.List;
import java.util.Set;
/**
 * 角色业务层
 * 
 * @author Carry xie
 */
public interface SysRoleService
{

    /**
     * 根据用户ID查询角色
     * 
     * @param userId 用户ID
     * @return 权限列表
     */
    public Set<String> selectRoleKeys(Long userId);


}
