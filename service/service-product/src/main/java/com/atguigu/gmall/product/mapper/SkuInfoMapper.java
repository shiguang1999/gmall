package com.atguigu.gmall.product.mapper;

import com.atguigu.gmall.model.product.SkuInfo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import javax.websocket.server.PathParam;

/**
* @author shiguang
* @description 针对表【sku_info(库存单元表)】的数据库操作Mapper
* @createDate 2022-05-19 14:32:45
* @Entity com.atguigu.gmall.product.domain.SkuInfo
*/
public interface SkuInfoMapper extends BaseMapper<SkuInfo> {

    //上下架
    void updateIsSaleById(@PathParam("skuId") Long skuId, @PathParam("i") int i);
}




