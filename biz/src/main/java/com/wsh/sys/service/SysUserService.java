package com.wsh.sys.service;

import com.wsh.sys.domain.SysUser;

public interface SysUserService {
	
    /**
     * 通过用户名查询用户
     * 
     * @param userName 用户名
     * @return 用户对象信息
     */
    public SysUser selectUserByLoginName(String userName);

    /**
     * 通过手机号码查询用户
     * 
     * @param phoneNumber 手机号码
     * @return 用户对象信息
     */
    public SysUser selectUserByPhoneNumber(String phoneNumber);

    /**
     * 通过邮箱查询用户
     * 
     * @param email 邮箱
     * @return 用户对象信息
     */
    public SysUser selectUserByEmail(String email);
    
    /**
     * 校验用户名称是否唯一
     * 
     * @param loginName 登录名称
     * @return 结果
     */
    public String checkLoginNameUnique(String loginName);

    /**
     * 校验手机号码是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    public String checkPhoneUnique(SysUser user);

    /**
     * 校验email是否唯一
     *
     * @param user 用户信息
     * @return 结果
     */
    public String checkEmailUnique(SysUser user);
    
    /**
     * 修改用户详细信息
     * 
     * @param user 用户信息
     * @return 结果
     */
    public int updateUserInfo(SysUser user);

}
