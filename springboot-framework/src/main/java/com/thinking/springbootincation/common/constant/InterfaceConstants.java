package com.thinking.springbootincation.common.constant;

/**
 * @Author：caoj
 * @Description：
 * @Date：Created in 2018/7/18
 */
public class InterfaceConstants {

    /**
     * interface path and name
     */
    public static final String USER_REQ = "";

    /**
     * return value
     */
    public static final Integer CODE_SYSTEM_BUSY = -1;// 系统繁忙，稍后重试
    public static final Integer CODE_SUCCESS = 0;// 成功
    public static final Integer CODE_POST_PARAM_ERROR = 4003;// post参数错误
    public static final Integer CODE_SYSTEM_ERROR = 500;// 系统错误

    /**
     * return message
     */
    public static final String MSG_SYSTEM_BUSY = "web busy, please try again later.";
    public static final String MSG_POST_PARAM_ERROR = "post param is illegal.";
    public static final String MSG_SYSTEM_ERROR = "web error, please try again later.";
    public static final String MSG_SUCCESS = "request success.";


}
