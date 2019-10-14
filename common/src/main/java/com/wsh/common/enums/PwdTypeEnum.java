package com.wsh.common.enums;

public enum PwdTypeEnum {
	INITIAL("0", "初始密码"), MODIFY("1", "已经修改");

    private final String code;
    private final String info;

    PwdTypeEnum(String code, String info)
    {
        this.code = code;
        this.info = info;
    }

    public String getCode()
    {
        return code;
    }

    public String getInfo()
    {
        return info;
    }
}
