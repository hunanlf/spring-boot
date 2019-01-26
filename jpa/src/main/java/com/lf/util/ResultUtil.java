package com.lf.util;

import lombok.Data;

/**
 * Created by liufeng on 2018/6/4
 */
@Data
public class ResultUtil {

    public static Message success(Object o){
        Message message = new Message();
        message.setCode(0);
        message.setMsg("success");
        message.setData(o);
        return message;
    }

    public static Message error(Integer code,String msg){
        Message message = new Message();
        message.setCode(code);
        message.setMsg(msg);
        return message;
    }

}
