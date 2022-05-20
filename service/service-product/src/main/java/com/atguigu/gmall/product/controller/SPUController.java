package com.atguigu.gmall.product.controller;


import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.SpuInfo;
import com.atguigu.gmall.product.service.SpuInfoService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/product")
public class SPUController {


    @Autowired
    SpuInfoService spuInfoService;


    //获取spu分页列表
    @GetMapping("/{page}/{limit}")
    public Result<Page<SpuInfo>> getSpuPage(@PathVariable("page") Long page,
                                            @PathVariable("limit") Long limit,
                                            SpuInfo spuInfo) {


        Page<SpuInfo> spuInfoPage = new Page<>(page, limit);

        Page<SpuInfo> spuInfoPageList = spuInfoService.getSpuPage(spuInfoPage, spuInfo);
        return Result.ok(spuInfoPageList);
    }


    //添加spu
    //todo :需要修改
    @PostMapping("/saveSpuInfo")
    public Result saveSpuInfo(@RequestBody SpuInfo spuInfo) {
        spuInfoService.saveSpuInfo(spuInfo);
        return Result.ok();
    }



}
