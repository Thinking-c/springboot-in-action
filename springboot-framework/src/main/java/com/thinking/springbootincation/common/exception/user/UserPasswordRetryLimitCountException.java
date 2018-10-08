package com.thinking.springbootincation.common.exception.user;

/**
 * @Author：caoj
 * @Description： 用户错误记数异常类
 * @Date：Created in 2018/7/25
 */
public class UserPasswordRetryLimitCountException extends UserException {
    private static final long serialVersionUID = 1L;

    public UserPasswordRetryLimitCountException(int retryLimitCount, String password) {
        super("user.password.retry.limit.count", new Object[]{retryLimitCount, password});
    }
}
