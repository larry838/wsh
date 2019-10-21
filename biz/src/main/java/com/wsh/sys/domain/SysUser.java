package com.wsh.sys.domain;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.Email;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wsh.common.annotation.Excel;
import com.wsh.common.annotation.Excel.Type;
import com.wsh.common.core.domain.BaseEntity;
import com.wsh.common.enums.PwdTypeEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



/**
 * 用户对象 sys_user
 * 
 * @author Carry xie
 */
@Getter
@Setter
@NoArgsConstructor
@TableName(value = "sys_user")
public class SysUser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 用户ID */
    @Excel(name = "用户序号", prompt = "用户编号")

    @TableId(value="user_id", type= IdType.AUTO)
    private Long userId;
    
    /** 部门ID */
    @Excel(name = "部门编号", type = Type.IMPORT)
    @TableField(value = "dept_id")
    private Long deptId;
    
    /** 岗位ID */
    @TableField(value = "post_id")
    private Long postId;

    /** 登录名称 */
    @Excel(name = "登录名称")
    @TableField(value = "login_name")
    private String loginName;

    /** 用户名称 */
    @Excel(name = "用户名称")
    @TableField(value = "user_name")
    private String userName;

    /** 用户邮箱 */
    @Excel(name = "用户邮箱")
    @Email(message="email地址无效！")  
    @NotNull(message="email地址不能为空！")  
    private String email;

    /** 手机号码 */
    @Excel(name = "手机号码")
    private String phonenumber;

    /** 用户性别 */
    @Excel(name = "用户性别", readConverterExp = "M=男,F=女,U=未知")
    private String gender;

    /** 用户头像 */
    private String avatar;

    /** 密码 */
    private String password;

    /** 盐加密 */
    @JsonIgnore
    private String salt;

    /** 帐号状态（0正常 -1停用） */
    @Excel(name = "帐号状态", readConverterExp = "0=正常,-1=停用")
    private String status;

    /** 删除标志（0代表存在 -1代表删除） */
    @TableField(value = "del_flag")
    @TableLogic
    private String delFlag;

    /** 最后登陆IP */
    @Excel(name = "最后登陆IP", type = Type.EXPORT)
    @TableField(value = "login_ip")
    private String loginIp;

    /** 最后登陆时间 */
    @Excel(name = "最后登陆时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss", type = Type.EXPORT)
    @TableField(value = "login_date")
    private Date loginDate;

    /** 部门对象 */
    @Excel(name = "部门名称", targetAttr = "deptName", type = Type.EXPORT)
    @TableField(exist = false)
    private SysDept dept;
    
    /**工作岗位*/
    @TableField(exist = false)
    private SysPost post;
    @TableField(exist = false)
    private List<SysRole> roles;

    /** 角色组 */
    @TableField(exist = false)
    private Long[] roleIds;

    /**密码是否修改*/
    private String modifyed;
    
    public boolean isRoot()
    {
        return isRoot(this.userId);
    }
    public static boolean isRoot(Long userId)
    {
        return userId != null && 1L == userId;
    }
  
    public boolean isInital(){
    	return PwdTypeEnum.INITIAL.getCode().equals(modifyed);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("userId", getUserId())
            .append("deptId", getDeptId())
            .append("postId", getPostId())
            .append("loginName", getLoginName())
            .append("userName", getUserName())
            .append("email", getEmail())
            .append("phonenumber", getPhonenumber())
            .append("gender", getGender())
            .append("avatar", getAvatar())
            .append("password", getPassword())
            .append("salt", getSalt())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("loginIp", getLoginIp())
            .append("loginDate", getLoginDate())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("dept", getDept())
            .append("post", getPost())
            .append("modify", getModifyed())
            .toString();
    }
}
