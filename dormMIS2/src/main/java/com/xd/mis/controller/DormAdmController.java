package com.xd.mis.controller;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xd.mis.entity.DormAdm;
import com.xd.mis.entity.Student;
import com.xd.mis.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.List;

//@CrossOrigin("*")//跨域,全部允许
@RestController
@RequestMapping("/dormadm")

public class DormAdmController extends StudentController{

    private StudentServiceImpl stuService;
    //分页列表 模糊查询学生个人信息
    @GetMapping("/name") //不改变数据库数据就用get
    public Page<Student> pageByName(
            @RequestParam(defaultValue = "") String stuname,
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "15") Integer size){

        return stuService.getStuByName(new Page<>(current,size),stuname);
    }

    //分页列表 模糊查询宿舍人员名单
    @GetMapping("/dorm") //不改变数据库数据就用get
    public Page<Student> selectDormStus(
            @RequestParam(defaultValue = "") String dormid,
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "15") Integer size){

        return stuService.selectDormStus(new Page<>(current,size),dormid);
    }

    //数据保存和新增
    @PostMapping("/update") //改变数据库数据就用post
    public boolean saveOrUpdateById(@RequestBody Student student){
        return stuService.saveOrUpdateById(student);
    }

    //单选删除和批量删除
    @PostMapping("/delete") //改变数据库数据就用post
    public boolean delete(@RequestBody List<Integer> ids){
        return stuService.deleteBatchIds(ids);
    }

}
