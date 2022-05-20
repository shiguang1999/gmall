package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.*;
import com.atguigu.gmall.product.mapper.SpuInfoMapper;
import com.atguigu.gmall.product.service.SpuImageService;
import com.atguigu.gmall.product.service.SpuInfoService;
import com.atguigu.gmall.product.service.SpuSaleAttrService;
import com.atguigu.gmall.product.service.SpuSaleAttrValueService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author shiguang
 * @description 针对表【spu_info(商品表)】的数据库操作Service实现
 * @createDate 2022-05-19 11:23:08
 */
@Service
public class SpuInfoServiceImpl extends ServiceImpl<SpuInfoMapper, SpuInfo>
        implements SpuInfoService {

    @Autowired
    SpuInfoMapper spuInfoMapper;

    @Autowired
    SpuImageService spuImageService;

    @Autowired
    SpuSaleAttrService spuSaleAttrService;

    @Autowired
    SpuSaleAttrValueService spuSaleAttrValueService;

    @Override
    public Page<SpuInfo> getSpuPage(Page<SpuInfo> spuInfoPage, SpuInfo spuInfo) {

        QueryWrapper<SpuInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("category3_id", spuInfo.getCategory3Id());
        Page<SpuInfo> infoPage = spuInfoMapper.selectPage(spuInfoPage, wrapper);
        return infoPage;
    }

    @Override
    public List<BaseSaleAttr> getBaseSaleAttrList() {


        return null;
    }

    /**
     * 保存spuInfo
     *
     * @param spuInfo
     */
    @Transactional
    @Override
    public void saveSpuInfo(SpuInfo spuInfo) {
        //1.将基本属性存入到spu_info表中

        spuInfoMapper.insert(spuInfo);

        //获取spuid为了后续添加使用
        Long spuId = spuInfo.getId();

        //2.将图片信息存入到 spu_image表中
        List<SpuImage> spuImageList = spuInfo.getSpuImageList();
        for (SpuImage spuImage : spuImageList) {
            spuImage.setSpuId(spuId);
        }
        spuImageService.saveBatch(spuImageList);

        //3.将spu销售属性存入到spu_sale_attr和值spu_sale_attr_value

        List<SpuSaleAttr> spuSaleAttrList = spuInfo.getSpuSaleAttrList();
        for (SpuSaleAttr spuSaleAttr : spuSaleAttrList) {
            spuSaleAttr.setSpuId(spuId);
            spuSaleAttrService.save(spuSaleAttr);//保存了spu销售属性

            //获取销售值列表
            List<SpuSaleAttrValue> valueList = spuSaleAttr.getSpuSaleAttrValueList();

            for (SpuSaleAttrValue value : valueList) {

                value.setSpuId(spuId);
                value.setSaleAttrName(spuSaleAttr.getSaleAttrName());

            }

            spuSaleAttrValueService.saveBatch(valueList);
        }


    }
}




