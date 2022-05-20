package com.atguigu.gmall.product.service;

import com.atguigu.gmall.model.product.SkuInfo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author shiguang
* @description 针对表【sku_info(库存单元表)】的数据库操作Service
* @createDate 2022-05-19 14:32:45
*/
public interface SkuInfoService extends IService<SkuInfo> {

    /**
     * 保存商品spu
     * @param skuInfo
     */
    void saveSkuInfo(SkuInfo skuInfo);

    /**
     * 上下架
     * @param skuId
     * @param i
     */
    void UpOrDownSku(Long skuId, int i);
}
