package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseSaleAttr;
import com.atguigu.gmall.model.product.SpuInfo;
import com.atguigu.gmall.product.mapper.SpuInfoMapper;
import com.atguigu.gmall.product.service.SpuInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}




