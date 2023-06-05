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
@TableName("totalcost")   //表名映射
public class Totalcost {
    @TableId(value="dorm_id")
    private String dormID;

    @TableField(value="water_total")
    private String wTotal;

    @TableField(value="elec_total")
    private String eTotal;
}
