package com.thinking.springbootincation.common.exception.user;

/**
 * @Author：caoj
 * @Description： 用户错误最大次数异常类
 * @Date：Created in 2018/7/25
 */
public class UserPasswordRetryLimitExceedException extends UserException {
    private static final long serialVersionUID = 1L;

    public UserPasswordRetryLimitExceedException(int retryLimitCount) {
        super("user.password.retry.limit.exceed", new Object[]{retryLimitCount});
    }
}
