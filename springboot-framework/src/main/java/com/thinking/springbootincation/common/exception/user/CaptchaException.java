package com.thinking.springbootincation.common.exception.user;

/**
 * @Author：caoj
 * @Description： 验证码错误异常类
 * @Date：Created in 2018/7/25
 */
public class CaptchaException extends UserException {
    private static final long serialVersionUID = 1L;

    public CaptchaException() {
        super("user.jcaptcha.error", null);
    }
}
