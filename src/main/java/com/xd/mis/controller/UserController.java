package com.xd.mis.controller;

import cn.hutool.core.util.StrUtil;
import com.xd.mis.common.CodeConstants;
import com.xd.mis.common.Result;
import com.xd.mis.controller.dto.PasswordDto;
import com.xd.mis.controller.dto.StudentDto;
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
    public Result userRegister( StudentDto studentDto){
        String stuid = studentDto.getStuID();
        String pwd = studentDto.getPwd();

        if(StrUtil.isBlank(stuid) || StrUtil.isBlank(pwd)) {
            return Result.error(CodeConstants.CODE_400000,"参数错误");
        }
        return Result.success(stuService.userRegister(studentDto));
    }

    //登录用户
    @PostMapping("/login")
    public Result userLogin( StudentDto studentDto){
        String stuid = studentDto.getStuID();
        String pwd = studentDto.getPwd();
        if(StrUtil.isBlank(stuid) || StrUtil.isBlank(pwd)) {
            return Result.error(CodeConstants.CODE_400000,"参数错误");
        }
        return Result.success(stuService.userLogin(studentDto));
    }

    //修改密码
    @PostMapping("/edit")
    public Result editPassword(@RequestBody PasswordDto pwdDto){
        String uid = pwdDto.getUid();
        String oldpwd = pwdDto.getOldpwd();
        String newpwd = pwdDto.getNewpwd();
        if(StrUtil.isBlank(uid) || StrUtil.isBlank(oldpwd) || StrUtil.isBlank(newpwd)) {
            return Result.error(CodeConstants.CODE_400000,"参数错误");
        }
        return Result.success(stuService.editPassword(pwdDto));
    }
}
