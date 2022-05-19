package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseTrademark;
import com.atguigu.gmall.product.mapper.BaseTrademarkMapper;
import com.atguigu.gmall.product.service.BaseTrademarkService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author shiguang
 * @description 针对表【base_trademark(品牌表)】的数据库操作Service实现
 * @createDate 2022-05-18 19:35:22
 */
@Service
public class BaseTrademarkServiceImpl extends ServiceImpl<BaseTrademarkMapper, BaseTrademark> implements BaseTrademarkService {

    @Autowired
    BaseTrademarkMapper baseTrademarkMapper;

    @Override
    public Page<BaseTrademark> getBaseTrademarkPage(Long pageNum, Long limit) {

        Page<BaseTrademark> page = new Page<>(pageNum,limit);

        Page<BaseTrademark> baseTrademarkPage = baseTrademarkMapper.selectPage(page, null);
        return baseTrademarkPage;
    }
}




