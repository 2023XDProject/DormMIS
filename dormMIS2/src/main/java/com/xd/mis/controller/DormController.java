package com.xd.mis.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xd.mis.entity.Dorm;
import com.xd.mis.service.impl.DormServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dorm")
public class DormController {
    @Autowired
    private DormServiceImpl dormService;

    //分页列表 模糊查询宿舍信息
    @GetMapping("/info") //不改变数据库数据就用get
    public Page<Dorm> pageByDormid(
            @RequestParam(defaultValue = "") String dormid,
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "15") Integer size){
        return dormService.getDormInfo(new Page<>(current,size),dormid);
    }

    //分页列表 模糊查询宿舍剩余水电费
    @GetMapping("/balance") //不改变数据库数据就用get
    public Page<Dorm> pageByBalance(
            @RequestParam(defaultValue = "") String dormid,
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "15") Integer size){
        return dormService.getBalance(new Page<>(current,size),dormid);
    }

    //数据保存和新增
    @PostMapping("/update") //改变数据库数据就用post
    public boolean saveOrUpdateById(@RequestBody Dorm dorm){
        return dormService.saveOrUpdateById(dorm);
    }

    /**
     * 单选删除和批量删除
     * @param ids
     * @return
     */
    @PostMapping("/delete") //改变数据库数据就用post
    public boolean delete(@RequestBody List<Integer> ids){
        return dormService.deleteBatchIds(ids);
    }
}
