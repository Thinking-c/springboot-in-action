package com.chargedot.malfunction.controller.entity.response;

/**
 * @Author：caoj
 * @Description：返回基类
 * @Data：Created in 2017/11/20
 */
public class BaseVo {
  private Integer code;
  private String msg;

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }

  public BaseVo() {
    this.code = 0;
    this.msg = "";
  }

  public BaseVo(Integer code, String msg) {
    this.code = code;
    this.msg = msg;
  }
}
