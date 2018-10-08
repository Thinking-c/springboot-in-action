package com.thinking.springbootincation.project.system.role.domain;

/**
 * @Author：caoj
 * @Description： 角色和菜单关联 sys_role_menu
 * @Date：Created in 2018/7/26
 */
public class RoleMenu {
    /**
     * 角色ID
     */
    private Long roleId;
    /**
     * 菜单ID
     */
    private Long menuId;

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    @Override
    public String toString() {
        return "RoleMenu [roleId=" + roleId + ", menuId=" + menuId + "]";
    }

}
