package com.thinking.springbootincation.framework.shiro.service;

import com.thinking.springbootincation.common.constant.CommonConsants;
import com.thinking.springbootincation.common.constant.ShiroConstants;
import com.thinking.springbootincation.common.constant.UserConstants;
import com.thinking.springbootincation.common.exception.user.CaptchaException;
import com.thinking.springbootincation.common.exception.user.UserBlockedException;
import com.thinking.springbootincation.common.exception.user.UserNotExistsException;
import com.thinking.springbootincation.common.exception.user.UserPasswordNotMatchException;
import com.thinking.springbootincation.common.util.*;
import com.thinking.springbootincation.project.system.user.domain.User;
import com.thinking.springbootincation.project.system.user.domain.UserStatus;
import com.thinking.springbootincation.project.system.user.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/24
 */
@Component
public class LoginService {

    @Autowired
    private PasswordService passwordService;

    @Autowired
    private IUserService userService;

    /**
     * 登录
     */
    public User login(String username, String password) {
        // 验证码校验
        if (!StringUtils.isEmpty(ServletUtils.getRequest().getAttribute(ShiroConstants.CURRENT_CAPTCHA))) {
            SystemLogUtils.log(username, CommonConsants.LOGIN_FAIL, MessageUtils.message("user.jcaptcha.error"));
            throw new CaptchaException();
        }
        // 用户名或密码为空 错误
        if (StringUtils.isEmpty(username) || StringUtils.isEmpty(password)) {
            SystemLogUtils.log(username, CommonConsants.LOGIN_FAIL, MessageUtils.message("not.null"));
            throw new UserNotExistsException();
        }
        // 密码如果不在指定范围内 错误
        if (password.length() < UserConstants.PASSWORD_MIN_LENGTH
                || password.length() > UserConstants.PASSWORD_MAX_LENGTH) {
            SystemLogUtils.log(username, CommonConsants.LOGIN_FAIL, MessageUtils.message("user.password.not.match"));
            throw new UserPasswordNotMatchException();
        }

        // 用户名不在指定范围内 错误
        if (username.length() < UserConstants.USERNAME_MIN_LENGTH
                || username.length() > UserConstants.USERNAME_MAX_LENGTH) {
            SystemLogUtils.log(username, CommonConsants.LOGIN_FAIL, MessageUtils.message("user.password.not.match"));
            throw new UserPasswordNotMatchException();
        }

        // 查询用户信息
        User user = userService.selectUserByLoginName(username);

        if (user == null && maybeMobilePhoneNumber(username)) {
            user = userService.selectUserByPhoneNumber(username);
        }

        if (user == null && maybeEmail(username)) {
            user = userService.selectUserByEmail(username);
        }

        if (user == null || UserStatus.DELETED.getCode().equals(user.getDelFlag())) {
            SystemLogUtils.log(username, CommonConsants.LOGIN_FAIL, MessageUtils.message("user.not.exists"));
            throw new UserNotExistsException();
        }

        passwordService.validate(user, password);

        if (UserStatus.DISABLE.getCode().equals(user.getStatus())) {
            SystemLogUtils.log(username, CommonConsants.LOGIN_FAIL, MessageUtils.message("user.blocked", user.getRemark()));
            throw new UserBlockedException(user.getRemark());
        }
        SystemLogUtils.log(username, CommonConsants.LOGIN_SUCCESS, MessageUtils.message("user.login.success"));
        recordLoginInfo(user);
        return user;
    }

    private boolean maybeEmail(String username) {
        if (!username.matches(UserConstants.EMAIL_PATTERN)) {
            return false;
        }
        return true;
    }

    private boolean maybeMobilePhoneNumber(String username) {
        if (!username.matches(UserConstants.MOBILE_PHONE_NUMBER_PATTERN)) {
            return false;
        }
        return true;
    }

    /**
     * 记录登录信息
     */
    public void recordLoginInfo(User user) {
        user.setLoginIp(ShiroUtils.getIp());
        user.setLoginDate(DateUtils.getNowDate());
        userService.updateUserInfo(user);
    }


}
