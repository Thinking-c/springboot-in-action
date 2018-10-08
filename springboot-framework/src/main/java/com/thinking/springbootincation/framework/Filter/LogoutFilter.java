package com.thinking.springbootincation.framework.Filter;

import com.thinking.springbootincation.common.constant.CommonConsants;
import com.thinking.springbootincation.common.util.MessageUtils;
import com.thinking.springbootincation.common.util.ShiroUtils;
import com.thinking.springbootincation.common.util.StringUtils;
import com.thinking.springbootincation.common.util.SystemLogUtils;
import com.thinking.springbootincation.project.system.user.domain.User;
import org.apache.shiro.session.SessionException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/25
 */
public class LogoutFilter extends org.apache.shiro.web.filter.authc.LogoutFilter {

    private static final Logger log = LoggerFactory.getLogger(LogoutFilter.class);

    /**
     * 退出后重定向的地址
     */
    private String loginUrl;

    public String getLoginUrl() {
        return loginUrl;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    @Override
    protected boolean preHandle(ServletRequest request, ServletResponse response) throws Exception {
        try {
            Subject subject = getSubject(request, response);
            String redirectUrl = getRedirectUrl(request, response, subject);
            try {
                User user = (User) ShiroUtils.getSubject().getPrincipal();
                if (StringUtils.isNotNull(user)) {
                    String loginName = user.getLoginName();
                    // 记录用户退出日志
                    SystemLogUtils.log(loginName, CommonConsants.LOGOUT, MessageUtils.message("user.logout.success"));
                }
                // 退出登录
                subject.logout();
            } catch (SessionException e) {
                log.error("logout fail.", e);
            }
            issueRedirect(request, response, redirectUrl);
        } catch (Exception e) {
            log.debug("Encountered session exception during logout.  This can generally safely be ignored.", e);
        }
        return false;
    }

    /**
     * 退出跳转URL
     */
    @Override
    protected String getRedirectUrl(ServletRequest request, ServletResponse response, Subject subject) {
        String url = getLoginUrl();
        if (StringUtils.isNotEmpty(url)) {
            return url;
        }
        return super.getRedirectUrl(request, response, subject);
    }

}
