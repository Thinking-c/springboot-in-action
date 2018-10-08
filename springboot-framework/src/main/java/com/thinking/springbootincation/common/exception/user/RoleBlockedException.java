package com.thinking.springbootincation.common.exception.user;

/**
 * @Author：caoj
 * @Description： 角色锁定异常类
 * @Date：Created in 2018/7/25
 */
public class RoleBlockedException extends UserException {

    private static final long serialVersionUID = 1L;

    public RoleBlockedException(String reason) {
        super("role.blocked", new Object[]{reason});
    }

}
