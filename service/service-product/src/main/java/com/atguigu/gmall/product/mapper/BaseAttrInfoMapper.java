package com.atguigu.gmall.product.mapper;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author shiguang
* @description 针对表【base_attr_info(属性表)】的数据库操作Mapper
* @createDate 2022-05-18 15:40:05
* @Entity com.atguigu.gmall.product.domain.BaseAttrInfo
*/
public interface BaseAttrInfoMapper extends BaseMapper<BaseAttrInfo> {

    /**
     * 根据分类id获取平台属性和属性值
     * @param category1Id
     * @param category2Id
     * @param category3Id
     * @return
     */
    List<BaseAttrInfo> selectAttrInfoAndAttrValueByCategoryId(@Param("category1Id") Long category1Id,
                                                              @Param("category2Id") Long category2Id,
                                                              @Param("category3Id")Long category3Id);

    /**
     * 根据平台属性ID获取平台属性对象数据
     * @param attrId
     * @return
     */
    List<BaseAttrValue> findAttrValueByAttrId(Long attrId);
}




