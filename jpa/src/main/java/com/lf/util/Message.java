package com.lf.util;

import lombok.Data;

/**
 * Created by liufeng on 2018/6/4
 */
@Data
public class Message<T> {

    /**错误码 */
    private Integer code;

    /**提示消息 */
    private String msg;

    /**具体内容 */
    private T data;

}
