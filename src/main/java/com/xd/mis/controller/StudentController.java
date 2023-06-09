package com.xd.mis.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xd.mis.common.CodeConstants;
import com.xd.mis.common.Result;
import com.xd.mis.controller.dto.StudentDto;
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

    //分页列表 模糊查询学生个人信息
    @GetMapping("/info") //不改变数据库数据就用get
    public Result pageByName(@RequestParam String stuid){
        if(StrUtil.isBlank(stuid)) {
            return Result.error(CodeConstants.CODE_400000,"参数错误");
        }
        return Result.success(stuService.getStuByID(new Page<>(1,5),stuid));
    }

    //分页列表 模糊查询宿舍人员名单
    @GetMapping("/dorm") //不改变数据库数据就用get
    public Result selectDormStus(@RequestParam String dormid){
        if(StrUtil.isBlank(dormid)) {
            return Result.error(CodeConstants.CODE_400000,"参数错误");
        }
        return Result.success(stuService.selectDormStus(new Page<>(1,5),dormid));
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
