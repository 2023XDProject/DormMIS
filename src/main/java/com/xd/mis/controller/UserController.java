package com.xd.mis.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xd.mis.entity.Payment;
import com.xd.mis.entity.Student;
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
    public void userRegister(@RequestBody Student user){
        stuService.userRegister(user);
//        if(!stuService.checkUserExist(user.getStuID())) {//如果不存在
//            stuService.userRegister(user);//注册
//            return true;
//        }
//        else return false;//如果存在,返回账号已存在
    }

    //登录用户
    @GetMapping("/login") //不改变数据库数据就用get
    public void userLogin(
            @RequestParam(defaultValue = "") String uid,
            @RequestParam(defaultValue = "") String password){

//        if(stuService.userLogin(uid,password)) 进入下一个页面
//        else //用户不存在,提示注册
    }
}
