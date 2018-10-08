package com.thinking.springbootincation.project.system.user.controller;

import com.thinking.springbootincation.framework.config.ProjectConfig;
import com.thinking.springbootincation.framework.web.controller.BaseController;
import com.thinking.springbootincation.project.system.menu.domain.Menu;
import com.thinking.springbootincation.project.system.menu.service.IMenuService;
import com.thinking.springbootincation.project.system.user.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @Author：caoj
 * @Description： 首页
 * @Date：Created in 2018/7/26
 */
@Controller
public class IndexController extends BaseController {
    @Autowired
    private IMenuService menuService;

    @Autowired
    private ProjectConfig projectConfig;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap) {
        // 取身份信息
        User user = getUser();
        // 根据用户id取出菜单
        List<Menu> menus = menuService.selectMenusByUserId(user.getUserId());
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", projectConfig.getCopyrightYear());
        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(ModelMap mmap) {
        mmap.put("version", projectConfig.getVersion());
        return "main";
    }

}
