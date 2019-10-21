package com.wsh;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.wsh.sys.domain.SysUser;
import com.wsh.sys.mapper.SysUserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@MapperScan("com.wsh.sys.mapper")
public class UserTest {
 
    @Autowired
    private SysUserMapper userMapper;

//    String str=getRandomString(5);
//    @Test
//    public void testCreate(){
//    	SysUser entity= new SysUser();
//    	entity.setLoginName(str);
//    	userMapper.insert(entity);
//    }
//        
    @Test 
    public void testDel(){
    	//userMapper.deleteById(40);
    	userMapper.delete(new QueryWrapper<SysUser>().eq("login_name", "mOdzY"));
    }
//    
//    public static String getRandomString(int length){
//        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
//        Random random=new Random();
//        StringBuffer sb=new StringBuffer();
//        for(int i=0;i<length;i++){
//          int number=random.nextInt(62);
//          sb.append(str.charAt(number));
//        }
//        return sb.toString();
//    }
//     @Test
//    public void testUpdate() {
//    	 SysUser entity= new SysUser();
//    	 entity.setUserId(40L);
//    	 entity.setEmail("xiejian@sohu.com");
//    	 userMapper.updateById(entity);
//     }
   /* @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<SysUser> userList = userMapper.selectList(null);
        Assert.assertEquals(5, userList.size());
        userList.forEach(System.out::println);
    }
    */

}
