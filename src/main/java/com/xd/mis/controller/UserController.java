package com.xd.mis.controller;

import cn.hutool.core.util.StrUtil;
import com.xd.mis.common.CodeConstants;
import com.xd.mis.common.Result;
import com.xd.mis.controller.dto.UserDto;
import com.xd.mis.service.impl.StudentServiceImpl;
import org.apache.coyote.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private StudentServiceImpl stuService;

    //注册用户
//    @PostMapping("/register") //改变数据库数据就用post
//    public Result userRegister(
//            @RequestBody() UserDto userDto){
//        String uid = userDto.getUid();
//        String pwd = userDto.getPwd();
//        if(StrUtil.isBlank(uid) || StrUtil.isBlank(pwd)) {
//            return false;
//        }
//        return stuService.userRegister(uid,pwd);
//    }

    //登录用户@RequestBody
    @PostMapping("/login")
    public Result userLogin(UserDto userDto){
        String uid = userDto.getUid();
        String pwd = userDto.getPwd();

        if(StrUtil.isBlank(uid) || StrUtil.isBlank(pwd)) {
            return Result.error(CodeConstants.CODE_400000,"参数错误");
        }
        UserDto dto = stuService.userLogin(userDto);
        return Result.success(dto);
    }

//    @PostMapping("/edit")
//    public Result editPassword(
//            @RequestParam String uid,
//            @RequestParam String oldpwd,
//            @RequestParam String newpwd){
//        if(StrUtil.isBlank(uid) || StrUtil.isBlank(oldpwd) || StrUtil.isBlank(newpwd)) {
//            return false;
//        }
//        return stuService.editPassword(uid,oldpwd,newpwd);
//    }
}
