package com.lf.util;

import lombok.Data;

/**
 * Created by liufeng on 2018/6/4
 */
@Data
public class UserException extends RuntimeException{

    private Integer code;

    public UserException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

}
