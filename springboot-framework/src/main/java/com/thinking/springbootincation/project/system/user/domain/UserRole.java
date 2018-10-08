package com.thinking.springbootincation.project.system.user.domain;

 /**
 *
 * @Author：caoj
 * @Description： 用户角色关联 sys_user_role
 * @Date：Created in 2018/7/26
 */
public class UserRole {
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 角色ID
     */
    private Long roleId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "UserRole [userId=" + userId + ", roleId=" + roleId + "]";
    }

}
