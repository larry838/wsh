package com.wsh.framework.hander;

import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.wsh.framework.shiro.utils.ShiroUtils;

import java.util.Date;

/**
 * 公共字段自动填充
 */
@Component
public class AutoMetaObjectHandler implements MetaObjectHandler {

    public void insertFill(MetaObject metaObject) {
    	Date date=new Date();
        setFieldValByName("updateTime", date, metaObject);
        setFieldValByName("createTime", date, metaObject);
       // setFieldValByName("createBy",ShiroUtils.getLoginName(),metaObject);
    }

    public void updateFill(MetaObject metaObject) {
        setFieldValByName("updateTime", new Date(), metaObject);
        //setFieldValByName("updateBy",ShiroUtils.getLoginName(),metaObject);
    }

}