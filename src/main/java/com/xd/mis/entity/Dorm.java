package com.xd.mis.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                //省掉所有get set toString方法
@AllArgsConstructor  //自动完成有参构造
@NoArgsConstructor   //自动完成无参构造
@TableName("dorm")   //若名称不对应需标注
public class Dorm {
    @TableId(value="dorm_id")
    private String dormID;

    @TableField(value="water_balance")
    private double wBalance;

    @TableField(value="elec_balance")
    private double eBalance;

    @TableField(value="stu_number")
    private Integer sNumber;
}
