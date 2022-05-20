package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.SkuInfo;
import com.atguigu.gmall.product.service.SkuInfoService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/product")
public class SkuController {

    @Autowired
    SkuInfoService skuInfoService;

    //获取sku分页列表
    @GetMapping("/list/{page}/{limit}")
    public Result getSkuPage(@PathVariable Long page,
                             @PathVariable Long limit) {

        Page<SkuInfo> skuInfoPage = new Page<>(page, limit);

        Page<SkuInfo> pageList = skuInfoService.page(skuInfoPage);
        return Result.ok(pageList);
    }


    //保存商品spu
    @PostMapping("/saveSkuInfo")
    public Result saveSkuInfo(@RequestBody SkuInfo skuInfo) {

        skuInfoService.saveSkuInfo(skuInfo);

        return Result.ok();
    }


    //todo:下架
    @GetMapping("/cancelSale/{skuId}")
    public Result cancelSale(@PathVariable Long skuId) {
        skuInfoService.UpOrDownSku(skuId, 0);
        return Result.ok();
    }

    //上架
    @GetMapping("/onSale/{skuId}")
    public Result onSale(@PathVariable Long skuId) {
        skuInfoService.UpOrDownSku(skuId, 1);
        return Result.ok();
    }
}
