package com.xd.mis.controller.dto;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class DormDto {
    private String dormID;
    private Float wBalance;
    private Float eBalance;
    private Integer sNumber;
}
