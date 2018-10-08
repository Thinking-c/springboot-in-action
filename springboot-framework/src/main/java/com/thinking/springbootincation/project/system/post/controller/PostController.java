package com.thinking.springbootincation.project.system.post.controller;

import com.thinking.springbootincation.common.constant.BusinessType;
import com.thinking.springbootincation.common.util.ExcelUtil;
import com.thinking.springbootincation.framework.aspect.annotation.Log;
import com.thinking.springbootincation.framework.web.controller.BaseController;
import com.thinking.springbootincation.framework.web.domain.AjaxResult;
import com.thinking.springbootincation.framework.web.page.TableDataInfo;
import com.thinking.springbootincation.project.system.post.domain.Post;
import com.thinking.springbootincation.project.system.post.service.IPostService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author：caoj
 * @Description： 岗位信息
 * @Date：Created in 2018/7/26
 */
@Controller
@RequestMapping("/system/post")
public class PostController extends BaseController {
    private String prefix = "system/post";

    @Autowired
    private IPostService postService;

    @RequiresPermissions("system:post:view")
    @GetMapping()
    public String operlog() {
        return prefix + "/post";
    }

    @RequiresPermissions("system:post:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Post post) {
        startPage();
        List<Post> list = postService.selectPostList(post);
        return getDataTable(list);
    }

    @Log(title = "岗位管理", action = BusinessType.EXPORT)
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Post post) throws Exception {
        try {
            List<Post> list = postService.selectPostList(post);
            ExcelUtil<Post> util = new ExcelUtil<Post>(Post.class);
            return util.exportExcel(list, "post");
        } catch (Exception e) {
            return error("导出Excel失败，请联系网站管理员！");
        }
    }

    @RequiresPermissions("system:post:remove")
    @Log(title = "岗位管理", action = BusinessType.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        try {
            return toAjax(postService.deletePostByIds(ids));
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

    /**
     * 新增岗位
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存岗位
     */
    @RequiresPermissions("system:post:add")
    @Log(title = "岗位管理", action = BusinessType.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Post post) {
        return toAjax(postService.insertPost(post));
    }

    /**
     * 修改岗位
     */
    @GetMapping("/edit/{postId}")
    public String edit(@PathVariable("postId") Long postId, ModelMap mmap) {
        mmap.put("post", postService.selectPostById(postId));
        return prefix + "/edit";
    }

    /**
     * 修改保存岗位
     */
    @RequiresPermissions("system:post:edit")
    @Log(title = "岗位管理", action = BusinessType.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Post post) {
        return toAjax(postService.updatePost(post));
    }

}