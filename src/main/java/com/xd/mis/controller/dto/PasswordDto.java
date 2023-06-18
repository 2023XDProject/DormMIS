package com.xd.mis.controller.dto;

import lombok.Data;

@Data
public class PasswordDto {
    private String uid;
    private String oldpwd;
    private String newpwd;
}
