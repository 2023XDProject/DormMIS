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
    public Boolean userRegister(
            @RequestParam(defaultValue = "") String uid,
            @RequestParam(defaultValue = "12345") String pwd){

        return stuService.userRegister(uid,pwd);
    }

    //登录用户
    @GetMapping("/login")
    public Boolean userLogin(
            @RequestParam(defaultValue = "") String uid,
            @RequestParam(defaultValue = "") String pwd){

        return stuService.userLogin(uid,pwd);
    }
}
