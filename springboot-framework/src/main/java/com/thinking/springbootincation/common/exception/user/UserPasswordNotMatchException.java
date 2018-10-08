package com.thinking.springbootincation.common.exception.user;

/**
 * @Author：caoj
 * @Description： 用户密码不正确或不符合规范异常类
 * @Date：Created in 2018/7/25
 */
public class UserPasswordNotMatchException extends UserException {

    private static final long serialVersionUID = 1L;

    public UserPasswordNotMatchException() {
        super("user.password.not.match", null);
    }
}
