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
@TableName("dormadm")   //表名映射

public class DormAdm {
    @TableId(value="dormAdm_id",type = IdType.ASSIGN_ID)
    private String dormAdmID;

    @TableField(value="dormAdm_name")
    private String dormAdmName;

    @TableField(value="dormAdmsex")
    private String sex;

    @TableField(value="pwd",select = false)
    private String pwd;//保密字段不让查
}


