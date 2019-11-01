package com.wsh.sys.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.wsh.sys.domain.SysMenu;

/**
 * 菜单表 数据层
 * 
 * @author ruoyi
 */
public interface SysMenuMapper extends BaseMapper<SysMenu>
{
	
    /**
     * 查询系统所有菜单（含按钮）
     * 
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuAll();
    
    /**
     * 根据用户ID查询菜单（含按钮）
     * 
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuAllByUserId(Long userId);
    
    
    /**
     * 查询系统顶级正常显示菜单（不含按钮）
     * 
     * @return 菜单列表
     */
    public List<SysMenu> selectTopMenuAll();
    
    /**
     * 根据用户ID系统顶级正常显示菜单
     * 
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<SysMenu> selectTopMenusByUserId(Long userId);
	
	/**
     * 查询系统正常显示菜单（不含按钮）
     * 
     * @return 菜单列表
     */
	public List<SysMenu> selectMenuNormalAll();
    /**
     * 根据用户ID查询菜单
     * 
     * @param userId 用户ID
     * @return 菜单列表
     */
    public List<SysMenu> selectMenusByUserId(Long userId);
  
    /**
     * 根据角色ID查询菜单
     * 
     * @param roleId 角色ID
     * @return 菜单列表
     */
    public List<String> selectMenuTree(Long roleId);
    
    /**
     * 根据用户ID查询权限
     * 
     * @param userId 用户ID
     * @return 权限列表
     */
    public List<String> selectPermsByUserId(Long userId);

    /**
     * 校验菜单名称是否唯一
     * 
     * @param menuName 菜单名称
     * @param parentId 父菜单ID
     * @return 结果
     */
    public SysMenu checkMenuNameUnique(@Param("menuName") String menuName, @Param("parentId") Long parentId);

    /**
     * 查询菜单数量
     * 
     * @param parentId 菜单父ID
     * @return 结果
     */
    public int selectCountMenuByParentId(Long parentId);
    
    /**
     * 查询系统菜单列表
     * 
     * @param menu 菜单信息
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuList(SysMenu menu);
    
    /**
     * 查询系统菜单列表
     * 
     * @param menu 菜单信息
     * @return 菜单列表
     */
    public List<SysMenu> selectMenuListByUserId(SysMenu menu);
}
