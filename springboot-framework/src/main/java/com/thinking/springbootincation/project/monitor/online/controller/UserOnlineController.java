package com.thinking.springbootincation.project.monitor.online.controller;

import com.thinking.springbootincation.common.constant.BusinessType;
import com.thinking.springbootincation.common.util.ShiroUtils;
import com.thinking.springbootincation.framework.aspect.annotation.Log;
import com.thinking.springbootincation.framework.shiro.session.OnlineSessionDAO;
import com.thinking.springbootincation.framework.web.controller.BaseController;
import com.thinking.springbootincation.framework.web.domain.AjaxResult;
import com.thinking.springbootincation.framework.web.page.TableDataInfo;
import com.thinking.springbootincation.project.monitor.online.domain.OnlineSession;
import com.thinking.springbootincation.project.monitor.online.domain.OnlineStatusEnum;
import com.thinking.springbootincation.project.monitor.online.domain.UserOnline;
import com.thinking.springbootincation.project.monitor.online.service.IUserOnlineService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author：caoj
 * @Description： 在线用户监控
 * @Date：Created in 2018/7/25
 */
public class UserOnlineController extends BaseController {

    private String prefix = "monitor/online";

    @Autowired
    private IUserOnlineService userOnlineService;

    @Autowired
    private OnlineSessionDAO onlineSessionDAO;

    @RequiresPermissions("monitor:online:view")
    @GetMapping()
    public String online() {
        return prefix + "/online";
    }

    @RequiresPermissions("monitor:online:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(UserOnline userOnline) {
        startPage();
        List<UserOnline> list = userOnlineService.selectUserOnlineList(userOnline);
        return getDataTable(list);
    }

    @RequiresPermissions("monitor:online:batchForceLogout")
    @Log(title = "在线用户", action = BusinessType.FORCE)
    @PostMapping("/batchForceLogout")
    @ResponseBody
    public AjaxResult batchForceLogout(@RequestParam("ids[]") String[] ids) {
        for (String sessionId : ids) {
            UserOnline online = userOnlineService.selectOnlineById(sessionId);
            if (online == null) {
                return error("用户已下线");
            }
            OnlineSession onlineSession = (OnlineSession) onlineSessionDAO.readSession(online.getSessionId());
            if (onlineSession == null) {
                return error("用户已下线");
            }
            if (sessionId.equals(ShiroUtils.getSessionId())) {
                return error("当前登陆用户无法强退");
            }
            onlineSession.setStatus(OnlineStatusEnum.OFF_LINE);
            online.setStatus(OnlineStatusEnum.OFF_LINE);
            userOnlineService.saveOnline(online);
        }
        return success();
    }

    @RequiresPermissions("monitor:online:forceLogout")
    @Log(title = "在线用户", action = BusinessType.FORCE)
    @PostMapping("/forceLogout")
    @ResponseBody
    public AjaxResult forceLogout(String sessionId) {
        UserOnline online = userOnlineService.selectOnlineById(sessionId);
        if (sessionId.equals(ShiroUtils.getSessionId())) {
            return error("当前登陆用户无法强退");
        }
        if (online == null) {
            return error("用户已下线");
        }
        OnlineSession onlineSession = (OnlineSession) onlineSessionDAO.readSession(online.getSessionId());
        if (onlineSession == null) {
            return error("用户已下线");
        }
        onlineSession.setStatus(OnlineStatusEnum.OFF_LINE);
        online.setStatus(OnlineStatusEnum.OFF_LINE);
        userOnlineService.saveOnline(online);
        return success();
    }

}
