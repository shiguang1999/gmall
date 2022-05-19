package com.atguigu.gmall.product.controller;


import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.product.service.BaseAttrInfoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/admin/product")

public class BaseAttrController {
    @Autowired
    BaseAttrInfoService baseAttrInfoService;

    // 获取指定分类下所有的平台属性列表
    @GetMapping("/attrInfoList/{category1Id}/{category2Id}/{category3Id}")
    public Result getAttrInfoList(@PathVariable("category1Id") Long category1Id,
                                  @PathVariable("category2Id") Long category2Id,
                                  @PathVariable("category3Id") Long category3Id) {

        List<BaseAttrInfo> baseAttrInfoList = baseAttrInfoService.getAttrInfoList(category1Id, category2Id, category3Id);
        return Result.ok(baseAttrInfoList);
    }

    //保存平台属性
    @PostMapping("/saveAttrInfo")
    public Result saveAttrInfo(@RequestBody BaseAttrInfo baseAttrInfo) {

        //log.info("",baseAttrInfo);
        baseAttrInfoService.saveOrUpdateAttrInfo(baseAttrInfo);
        return Result.ok();
    }

    //根据平台属性ID获取平台属性对象数据
    @GetMapping("/getAttrValueList/{attrId}")
    public Result getAttrValueList(@PathVariable("attrId") Long attrId) {

        List<BaseAttrValue> list = baseAttrInfoService.findAttrValueByAttrId(attrId);
        return Result.ok(list);
    }


}
