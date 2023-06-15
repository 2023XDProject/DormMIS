package com.xd.mis.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

@Data                //省掉所有get set toString方法
@AllArgsConstructor  //自动完成有参构造
@NoArgsConstructor   //自动完成无参构造
@TableName("totalcost")   //表名映射
public class Totalcost {
    @TableId(value="dorm_id")
    private String dormID;

    @TableField(value="water_mtotal")
    private Integer wTotal;

    @TableField(value="elec_mtotal")
    private Integer eTotal;

    @TableField(value="year_month")
    @DateTimeFormat(pattern="yyyy-MM")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM")
    private String yyyymm;
}
