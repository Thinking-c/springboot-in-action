package com.thinking.springbootincation.project.monitor.online.domain;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/25
 */
public enum OnlineStatusEnum {

    ON_LINE("在线"),
    OFF_LINE("离线"),
    ;

    private final String info;

    OnlineStatusEnum(String info) {
        this.info = info;
    }

    public String getInfo() {
        return info;
    }
}
