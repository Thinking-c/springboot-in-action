package com.thinking.springbootincation.project.system.user.domain;

/**
 * @Author：caoj
 * @Description： 用户状态
 * @Date：Created in 2018/7/26
 */
public enum UserStatus {
    OK("0", "正常"),
    DISABLE("1", "停用"),
    DELETED("2", "删除"),
    ;

    private final String code;
    private final String info;

    UserStatus(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public String getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }
}
