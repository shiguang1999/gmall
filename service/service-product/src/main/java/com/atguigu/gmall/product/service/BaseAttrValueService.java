package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.BaseAttrValue;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author shiguang
* @description 针对表【base_attr_value(属性值表)】的数据库操作Service
* @createDate 2022-05-18 16:19:43
*/
public interface BaseAttrValueService extends IService<BaseAttrValue> {

    //根据id查询属性值
    List<BaseAttrValue> findAttrValueByAttrId(Long attrId);
}
