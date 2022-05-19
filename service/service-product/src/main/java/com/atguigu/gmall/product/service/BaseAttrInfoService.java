package com.atguigu.gmall.product.service;


import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author shiguang
* @description 针对表【base_attr_info(属性表)】的数据库操作Service
* @createDate 2022-05-18 15:40:05
*/
public interface BaseAttrInfoService extends IService<BaseAttrInfo> {


    /**
     * 根据分类id获取平台属性和值
     * @param category1Id
     * @param category2Id
     * @param category3Id
     * @return
     */
    List<BaseAttrInfo> getAttrInfoList(Long category1Id, Long category2Id, Long category3Id);

//    BaseAttrInfo findAttrInfoAndValueById(Long attrId);

    /**
     * 根据平台属性ID获取平台属性对象数据
     * @param attrId
     * @return
     */
    List<BaseAttrValue> findAttrValueByAttrId(Long attrId);

    /**
     * 保存或更新属性
     * @param baseAttrInfo
     */
    void saveOrUpdateAttrInfo(BaseAttrInfo baseAttrInfo);


    void saveAttrInfoAndValue(BaseAttrInfo attrInfo);


    void updateAttrInfoAndValue(BaseAttrInfo attrInfo);
}
