package com.thinking.springbootincation.project.tool.build;

import com.thinking.springbootincation.framework.web.controller.BaseController;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author：caoj
 * @Description： 表单构建
 * @Date：Created in 2018/7/24
 */
@Controller
@RequestMapping("/tool/build")
public class BuildController extends BaseController {
    private String prefix = "tool/build";

    @RequiresPermissions("tool:build:view")
    @GetMapping()
    public String build() {
        return prefix + "/build";
    }
}
