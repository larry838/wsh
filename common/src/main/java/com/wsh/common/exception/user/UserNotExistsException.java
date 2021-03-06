package com.wsh.common.exception.user;

/**
 * 用户不存在异常类
 * 
 * @author Carry xie
 */
public class UserNotExistsException extends UserException
{
    private static final long serialVersionUID = 1L;

    public UserNotExistsException()
    {
        super("user.not.exists", null);
    }
}
