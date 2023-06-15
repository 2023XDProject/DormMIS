package com.xd.mis.exception;

import lombok.Getter;

/**
 * 自定义异常
 */
@Getter
public class ServiceException extends RuntimeException{
    //状态码
    private String code;

    public ServiceException(String code, String msg){
        super(msg);
        this.code = code;
    }
}
