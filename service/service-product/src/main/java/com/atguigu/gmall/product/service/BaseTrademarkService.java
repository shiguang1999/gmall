package com.atguigu.gmall.product.service;


import com.atguigu.gmall.model.product.BaseTrademark;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author shiguang
* @description 针对表【base_trademark(品牌表)】的数据库操作Service
* @createDate 2022-05-18 19:35:22
*/
public interface BaseTrademarkService extends IService<BaseTrademark> {

    //获取品牌分页列表
    Page<BaseTrademark> getBaseTrademarkPage(Long pageNum, Long limit);

}
