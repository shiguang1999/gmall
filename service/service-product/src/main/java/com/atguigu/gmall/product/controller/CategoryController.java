package com.atguigu.gmall.product.controller;

import com.atguigu.gmall.common.result.Result;
import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.product.BaseCategory3;
import com.atguigu.gmall.product.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author shiguang
 * @data 22/5/17
 */
@RestController
@RequestMapping("/admin/product")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;


    //查询一级分类
    @GetMapping("/getCategory1")
    public Result getCategory1() {
      List<BaseCategory1> category1List= categoryService.getAllCategory1();
        return Result.ok(category1List);
    }


    //查询二级分类
    @GetMapping("/getCategory2/{category1Id}")
    public Result getCategory2(@PathVariable("category1Id") Long category1Id) {
        List<BaseCategory2> category2List= categoryService.getAllCategory2(category1Id);
        return Result.ok(category2List);
    }

    //查询三级分类
    @GetMapping("/getCategory3/{category2Id}")
    public Result getCategory3(@PathVariable("category2Id") Long category2Id) {
        List<BaseCategory3> category3List= categoryService.getAllCategory3(category2Id);
        return Result.ok(category3List);
    }
}
