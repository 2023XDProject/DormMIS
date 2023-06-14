package com.xd.mis.controller.dto;

import lombok.Data;

//接收前端登录请求的参数
@Data
public class UserDto {
    private String uid;
    private String pwd;
}
