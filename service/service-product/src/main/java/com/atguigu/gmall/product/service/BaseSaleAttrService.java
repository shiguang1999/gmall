package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseSaleAttr;
import com.atguigu.gmall.model.product.SpuSaleAttr;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author shiguang
* @description 针对表【base_sale_attr(基本销售属性表)】的数据库操作Service
* @createDate 2022-05-19 14:01:08
*/
public interface BaseSaleAttrService extends IService<BaseSaleAttr> {

    /**
     * 查询spuId对应的所有销售属性名和值
     * @param spuId
     * @return
     */
    List<SpuSaleAttr> getSpuSaleAttrAndValue(Long spuId);


    //获取销售属性
//    List<BaseSaleAttr> getBaseSaleAttrList();

}
