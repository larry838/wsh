package com.wsh.framework.shiro.service;

import java.util.Map;

import com.wsh.sys.domain.SysUser;

/**
 * Shiro-权限相关的业务处理
 *
 * @author Carry xie
 * @version 1.0
 * 
 * @date 2018/4/25 14:37
 * @since 1.0
 */
public interface ShiroService {

    /**
     * 初始化权限
     */
    Map<String, String> loadFilterChainDefinitions();

    /**
     * 重新加载权限
     */
    void updatePermission();

    /**
     * 重新加载用户权限
     *
     * @param user
     */
    void reloadAuthorizingByUserId(SysUser user);

    /**
     * 重新加载所有拥有roleId角色的用户的权限
     *
     * @param roleId
     */
    void reloadAuthorizingByRoleId(Long roleId);

}
