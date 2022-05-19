package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.product.service.BaseTrademarkService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/product")
public class BaseTrademarkController {//品牌


    @Autowired
    BaseTrademarkService baseTrademarkService;

    /**
     * 获取品牌分页列表
     *
     * @param pageNum
     * @param limit
     * @return
     */
    @GetMapping("/baseTrademark/{pageNum}/{limit}")
    public Result getBaseTrademarkPage(@PathVariable Long pageNum,
                                       @PathVariable Long limit) {
        //Page<BaseTrademark> baseTrademarkPage = baseTrademarkService.getBaseTrademarkPage(pageNum, limit);
        Page<BaseTrademark> baseTrademarkPage1 = new Page<>(pageNum, limit);
        Page<BaseTrademark> baseTrademarkPage = baseTrademarkService.page(baseTrademarkPage1);
        return Result.ok(baseTrademarkPage);
    }

    //新增品牌
    @PostMapping("/baseTrademark/save")
    public Result save(@RequestBody BaseTrademark baseTrademark) {

        baseTrademarkService.save(baseTrademark);
        return Result.ok();
    }

    //修改前回显
    @GetMapping("/baseTrademark/get/{id}")
    public Result getBaseTrademarkById(@PathVariable Long id) {

        BaseTrademark trademark = baseTrademarkService.getById(id);
        return Result.ok(trademark);
    }

    //修改品牌
    @PutMapping("/baseTrademark/update")
    public Result update(@RequestBody BaseTrademark baseTrademark) {
        baseTrademarkService.updateById(baseTrademark);
        return Result.ok();
    }


    //删除品牌
    @DeleteMapping("/baseTrademark/remove/{id}")
    public Result deleteBaseTrademark(@PathVariable Long id) {
        baseTrademarkService.removeById(id);
        return Result.ok();
    }
}
