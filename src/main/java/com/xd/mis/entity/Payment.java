package com.xd.mis.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data                //省掉所有get set toString方法
@AllArgsConstructor  //自动完成有参构造
@NoArgsConstructor   //自动完成无参构造
@TableName("payment")   //表名映射
public class Payment {
    @TableId(value="dorm_id")
    private String dormID;

    @TableField(value="stu_id")
    private String stuID;

    @TableField(value="water_bill")
    private Integer wBill;

    @TableField(value="elec_bill")
    private Integer eBill;

    @TableField(value="pay_datetime")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(timezone = "GMT+8",pattern = "yyyy-MM-dd HH:mm:ss")
    private Date pDateTime;
}
