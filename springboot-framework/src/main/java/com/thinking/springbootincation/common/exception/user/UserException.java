package com.thinking.springbootincation.common.exception.user;

import com.thinking.springbootincation.common.exception.base.BaseException;

/**
 * @Author：caoj
 * @Description： 用户信息异常类
 * @Date：Created in 2018/7/25
 */
public class UserException extends BaseException {

    private static final long serialVersionUID = 1L;

    public UserException(String code, Object[] args) {
        super("user", code, args, null);
    }

}
