package com.xd.mis.controller;

import cn.hutool.core.util.StrUtil;
import com.xd.mis.common.CodeConstants;
import com.xd.mis.common.Result;
import com.xd.mis.controller.dto.PasswordDto;
import com.xd.mis.controller.dto.UserDto;
import com.xd.mis.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private StudentServiceImpl stuService;

    //注册用户
    @PostMapping("/register") //改变数据库数据就用post
    public Result userRegister(UserDto userDto){
        String uid = userDto.getUid();
        String pwd = userDto.getPwd();

        if(StrUtil.isBlank(uid) || StrUtil.isBlank(pwd)) {
            return Result.error(CodeConstants.CODE_400000,"参数错误");
        }
        return Result.success(stuService.userRegister(userDto));
    }

    //登录用户
    @PostMapping("/login")
    public Result userLogin(UserDto userDto){
        String uid = userDto.getUid();
        String pwd = userDto.getPwd();

        if(StrUtil.isBlank(uid) || StrUtil.isBlank(pwd)) {
            return Result.error(CodeConstants.CODE_400000,"参数错误");
        }
        return Result.success(stuService.userLogin(userDto));
    }

    //修改密码
    @PostMapping("/edit")
    public Result editPassword(PasswordDto pwdDto){
        String uid = pwdDto.getUid();
        String oldpwd = pwdDto.getOldpwd();
        String newpwd = pwdDto.getNewpwd();
        if(StrUtil.isBlank(uid) || StrUtil.isBlank(oldpwd) || StrUtil.isBlank(newpwd)) {
            return Result.error(CodeConstants.CODE_400000,"参数错误");
        }
        return Result.success(stuService.editPassword(pwdDto));
    }
}
