package com.xd.mis.controller.dto;

import lombok.Data;

import java.util.Date;

@Data
public class EchargeDto {
    private String dormID;
    private String stuID;
    private Integer ebill;
    private Date pDateTime;
}
