package com.thinking.springbootincation.common.exception.user;

/**
 * @Author：caoj
 * @Description： 用户锁定异常类
 * @Date：Created in 2018/7/25
 */
public class UserBlockedException extends UserException {
    private static final long serialVersionUID = 1L;

    public UserBlockedException(String reason) {
        super("user.blocked", new Object[]{reason});
    }
}
