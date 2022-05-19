package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.product.BaseCategory3;

import java.util.List;

/**
 * @author shiguang
 * @data 22/5/17
 */
public interface CategoryService {


    //查询一级分类
    List<BaseCategory1> getAllCategory1();


    //查询二级分类
    List<BaseCategory2> getAllCategory2(Long category1Id);


    //查询三级分类
    List<BaseCategory3> getAllCategory3(Long category2Id);


}
