package com.lf.util;

/**
 * Created by liufeng on 2018/6/4
 */
public enum ResultEnum {

    UNKONW_ERROR(-1, "不确定错误"),
    //SUCCESS(0, "成功"),
    PRIMARY_SCHOOL(100, "打魂斗罗的年纪111111111111111111"),
    MIDDLE_SCHOOL(101, "玩QQ飞车的年纪");

    private Integer code;

    private String msg;

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
