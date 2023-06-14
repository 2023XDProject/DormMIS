package com.xd.mis.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xd.mis.entity.Student;
import com.xd.mis.service.impl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl stuService;

    /**
     * 分页列表 模糊查询
     * @param stuname
     * @param current
     * @param size
     * @return
     */
    @GetMapping("/pagebyname") //不改变数据库数据就用get
    public Page<Student> pageByName(
            @RequestParam(defaultValue = "") String stuname,
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "15") Integer size){
        return stuService.pageByName(current,size,stuname);
    }

    @GetMapping("/pagebydorm") //不改变数据库数据就用get
    public Page<Student> pageByDorm(
            @RequestParam(defaultValue = "") String dormid,
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "15") Integer size){
        return stuService.pageByDorm(current,size,dormid);
    }

    /**
     * 数据保存和新增
     * @param student
     * @return
     */
    @PostMapping("/update") //改变数据库数据就用post
    public boolean saveOrUpdateById(@RequestBody Student student){
        return stuService.saveOrUpdateById(student);
    }

    /**
     * 单选删除和批量删除
     * @param ids
     * @return
     */
    @PostMapping("/delete") //改变数据库数据就用post
    public boolean delete(@RequestBody List<Integer> ids){
        return stuService.deleteBatchIds(ids);
    }
}
