package com.xd.mis.controller.dto;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class StudentDto {
    private String stuID;
    private String dormID;
    private String stuName;
    private String sex;
    private Integer age;
    private String grade;
    private String major;
    private String pwd;
}
