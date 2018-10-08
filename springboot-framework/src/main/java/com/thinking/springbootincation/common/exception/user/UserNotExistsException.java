package com.thinking.springbootincation.common.exception.user;

/**
 * @Author：caoj
 * @Description： 用户不存在异常类
 * @Date：Created in 2018/7/25
 */
public class UserNotExistsException extends UserException {

    private static final long serialVersionUID = 1L;

    public UserNotExistsException() {
        super("user.not.exists", null);
    }
}
