package com.podinns.pms.common.exception.file;

import com.podinns.pms.common.exception.base.BaseException;

/**
 * 文件信息异常类
 * 
 * @author Carry xie
 */
public class FileException extends BaseException
{
    private static final long serialVersionUID = 1L;

    public FileException(String code, Object[] args)
    {
        super("file", code, args, null);
    }

}
