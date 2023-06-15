package com.xd.mis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                //省掉所有get set toString方法
@AllArgsConstructor  //自动完成有参构造
@NoArgsConstructor   //自动完成无参构造
@TableName("student")   //表名映射
public class Student {
    @TableId(value="stu_id",type = IdType.ASSIGN_ID)
    private String stuID;

    @TableField(value="dorm_id")
    private String dormID;

    @TableField(value="stu_name")
    private String stuName;

    @TableField(value="sex")
    private String sex;

    @TableField(value="age")
    private Integer age;

    @TableField(value="grade")
    private String grade;

    @TableField(value="major")
    private String major;

    @TableField(value="pwd",select = false)
    private String pwd;//保密字段不让查询
}
