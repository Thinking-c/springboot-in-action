package com.thinking.springbootincation.project.system.test.controller;

import com.thinking.springbootincation.framework.web.domain.AjaxResult;
import com.thinking.springbootincation.project.system.test.domain.TestUser;
import com.thinking.springbootincation.project.system.test.service.TestUserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Map;
import java.util.List;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/5
 */
@RestController
@RequestMapping("/test/*")
public class TestUserController {

    @Autowired
    private TestUserService testUserService;

    private static List<TestUser> userList = new ArrayList<>();

    static {
        userList.add(new TestUser(1, "admin", "123456"));
        userList.add(new TestUser(2, "zimo", "123456"));
    }

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表")
    @GetMapping(value = "/list")
    public List<TestUser> getUserList(){
        return testUserService.getUsers();
//        return userList;
    }

    @ApiOperation(value = "新增用户", notes = "新增用户")
    @PostMapping(value = "save")
    public AjaxResult save(TestUser user){
        return userList.add(user) ? AjaxResult.success() : AjaxResult.error();
    }

    @ApiOperation(value = "更新用户", notes = "更新用户信息")
    @ApiImplicitParam(name = "User", value = "单个用户信息", dataType = "User")
    @PutMapping("update")
    public AjaxResult update (TestUser user){
        return userList.remove(user) && userList.add(user) ? AjaxResult.success() : AjaxResult.error();
    }

    @ApiOperation(value = "删除用户", notes = "删除用户信息")
    @ApiImplicitParam(name = "User", value = "单个用户信息", dataType = "User")
    @DeleteMapping("delete")
    public AjaxResult delete (TestUser user){
        return userList.remove(user) ? AjaxResult.success() : AjaxResult.error();
    }

    @ApiOperation(value = "查询单个用户", notes = "查询单个用户")
    @ApiImplicitParam(name = "User", value = "查询单个用户信息", dataType = "User")
    @RequestMapping(value = "query", method = RequestMethod.POST)
    public TestUser getUser(@ApiParam(value = "id", required = true)@RequestBody Map<String, Object> params){
        TestUser user = userList.get((int)params.get("id"));
        return user;
    }

    @ApiOperation(value = "查询单个用户", notes = "通过id查询单个用户", httpMethod = "POST", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ApiImplicitParam(name = "User", value = "查询单个用户信息", dataType = "User")
    @RequestMapping(value = "queryById", method = RequestMethod.POST)
    public TestUser getUserById(@ApiParam(value = "id", required = true)@RequestParam Integer id){
        TestUser user = userList.get(id);
        return user;
    }


}