package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseCategory1;
import com.atguigu.gmall.model.product.BaseCategory2;
import com.atguigu.gmall.model.product.BaseCategory3;
import com.atguigu.gmall.product.dao.BaseCategory1Dao;
import com.atguigu.gmall.product.dao.BaseCategory2Dao;
import com.atguigu.gmall.product.dao.BaseCategory3Dao;
import com.atguigu.gmall.product.service.CategoryService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author shiguang
 * @data 22/5/17
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private BaseCategory1Dao baseCategory1Dao;


    @Autowired
    private BaseCategory2Dao baseCategory2Dao;


    @Autowired
    private BaseCategory3Dao baseCategory3Dao;

    @Override
    public List<BaseCategory1> getAllCategory1() {


        List<BaseCategory1> category1List = baseCategory1Dao.selectList(null);
        return category1List;
    }

    @Override
    public List<BaseCategory2> getAllCategory2( Long category1Id) {

        QueryWrapper<BaseCategory2> baseCategory2QueryWrapper = new QueryWrapper<>();
        baseCategory2QueryWrapper.eq("category1_id",category1Id);
        List<BaseCategory2> baseCategory2s = baseCategory2Dao.selectList(baseCategory2QueryWrapper);
        return baseCategory2s;
    }

    @Override
    public List<BaseCategory3> getAllCategory3(Long category2Id) {

        QueryWrapper<BaseCategory3> baseCategory3QueryWrapper = new QueryWrapper<>();
        baseCategory3QueryWrapper.eq("category2_id",category2Id);
        List<BaseCategory3> baseCategory3s = baseCategory3Dao.selectList(baseCategory3QueryWrapper);
        return baseCategory3s;
    }


}
