package com.thinking.springbootincation.framework.web.domain;

import java.util.HashMap;

/**
 * @Author：caoj
 * @Description： 通用web返回类
 * @Date：Created in 2018/7/5
 */
public class AjaxResult extends HashMap<String, Object>{

    public AjaxResult() {
    }

    public static AjaxResult error(){
        return error(1, "operator failure");
    }

    public static AjaxResult error(int code, String msg) {
        AjaxResult result = new AjaxResult();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    public static AjaxResult error(String msg) {
        return error(500, msg);
    }

    public static AjaxResult success(){
        return success("operator success");
    }

    public static AjaxResult success(int code, String msg) {
        AjaxResult result = new AjaxResult();
        result.put("code", code);
        result.put("msg", msg);
        return result;
    }

    public static AjaxResult success(String msg) {
        AjaxResult json = new AjaxResult();
        json.put("code", 0);
        json.put("msg", msg);
        return json;
    }

    @Override
    public Object put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
