package com.xd.mis.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xd.mis.entity.Dorm;
import com.xd.mis.entity.Totalcost;
import com.xd.mis.service.impl.DormServiceImpl;
import com.xd.mis.service.impl.TotalcostServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/totalcost")
public class TotalcostController {

    @Autowired
    private TotalcostServiceImpl totalcostService;

    //分页列表 模糊查询
    @GetMapping("/dorm") //不改变数据库数据就用get
    public Page<Totalcost> page(
            @RequestParam(defaultValue = "") String dormid,
            @RequestParam(defaultValue = "1") Integer current,
            @RequestParam(defaultValue = "15") Integer size){
        return totalcostService.page(current,size,dormid);
    }

    /**
     * 数据保存和新增
     * @param totalcost
     * @return
     */
    @PostMapping("/update") //改变数据库数据就用post
    public boolean saveOrUpdateById(@RequestBody Totalcost totalcost){
        return totalcostService.saveOrUpdateById(totalcost);
    }

    /**
     * 单选删除和批量删除
     * @param ids
     * @return
     */
    @PostMapping("/delete") //改变数据库数据就用post
    public boolean delete(@RequestBody List<Integer> ids){
        return totalcostService.deleteBatchIds(ids);
    }
}
