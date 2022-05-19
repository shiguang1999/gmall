package com.atguigu.gmall.product.controller;


import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseSaleAttr;
import com.atguigu.gmall.model.product.SkuInfo;
import com.atguigu.gmall.model.product.SpuInfo;
import com.atguigu.gmall.product.service.BaseSaleAttrService;
import com.atguigu.gmall.product.service.SkuInfoService;
import com.atguigu.gmall.product.service.SpuInfoService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin/product")
public class SPUController {


    @Autowired
    SpuInfoService spuInfoService;

    @Autowired
    BaseSaleAttrService baseSaleAttrService;

    @Autowired
    SkuInfoService skuInfoService;

    //获取spu分页列表
    @GetMapping("/{page}/{limit}")
    public Result<Page<SpuInfo>> getSpuPage(@PathVariable("page") Long page,
                                            @PathVariable("limit") Long limit,
                                            SpuInfo spuInfo) {


        Page<SpuInfo> spuInfoPage = new Page<>(page, limit);

        Page<SpuInfo> spuInfoPageList = spuInfoService.getSpuPage(spuInfoPage, spuInfo);
        return Result.ok(spuInfoPageList);
    }

    //获取销售属性
    @GetMapping("/baseSaleAttrList")
    public Result getBaseSaleAttrList() {
        List<BaseSaleAttr> baseSaleAttrList = baseSaleAttrService.getBaseSaleAttrList();
        return Result.ok(baseSaleAttrList);
    }


    //添加spu
    @PostMapping("/saveSpuInfo")
    public Result saveSpuInfo(@RequestBody SpuInfo spuInfo) {
        spuInfoService.save(spuInfo);
        return Result.ok();
    }


    //获取sku分页列表
    @GetMapping("/list/{page}/{limit}")
    public Result getSkuPage(@PathVariable Long page,
                             @PathVariable Long limit) {

        Page<SkuInfo> skuInfoPage = new Page<>(page, limit);

        Page<SkuInfo> pageList = skuInfoService.page(skuInfoPage);
        return Result.ok(pageList);
    }

    //下架
    @GetMapping("/cancelSale/{skuId}")
    public Result cancelSale(@PathVariable Long skuId) {

        return Result.ok();
    }

    //上架
    @GetMapping("/onSale/{skuId}")
    public Result onSale(Long skuId) {

        return Result.ok();
    }
}
