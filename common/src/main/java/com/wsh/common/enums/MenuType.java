package com.wsh.common.enums;


public enum MenuType {

    DIRECTORY("D","目录"),
    MENU("M","菜单"),
    BUTTON("B","按钮");
	
	  private String code;

	  private String name;

	private MenuType(String code, String name) {
		this.code = code;
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	  
	  
}
