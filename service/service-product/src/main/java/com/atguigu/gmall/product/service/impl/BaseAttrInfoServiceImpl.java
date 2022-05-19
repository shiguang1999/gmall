package com.atguigu.gmall.product.service.impl;

import com.atguigu.gmall.model.product.BaseAttrInfo;
import com.atguigu.gmall.model.product.BaseAttrValue;
import com.atguigu.gmall.product.mapper.BaseAttrInfoMapper;
import com.atguigu.gmall.product.mapper.BaseAttrValueMapper;
import com.atguigu.gmall.product.service.BaseAttrInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author shiguang
 * @description 针对表【base_attr_info(属性表)】的数据库操作Service实现
 * @createDate 2022-05-18 15:40:05
 */
@Service
public class BaseAttrInfoServiceImpl extends ServiceImpl<BaseAttrInfoMapper, BaseAttrInfo> implements BaseAttrInfoService {

    @Autowired
    BaseAttrInfoMapper baseAttrInfoMapper;


    @Autowired
    BaseAttrValueMapper baseAttrValueMapper;


    @Override
    public List<BaseAttrInfo> getAttrInfoList(Long category1Id, Long category2Id, Long category3Id) {
        return baseAttrInfoMapper.selectAttrInfoAndAttrValueByCategoryId(category1Id, category2Id, category3Id);
    }

//    @Override
//    public BaseAttrInfo findAttrInfoAndValueById(Long attrId) {
//
//        BaseAttrInfo baseAttrInfo = baseAttrInfoMapper.selectById(attrId);
//        return baseAttrInfo;
//    }


    @Transactional
    @Override
    public void saveOrUpdateAttrInfo(BaseAttrInfo baseAttrInfo) {
        Long id = baseAttrInfo.getId();
        if (id == null) {
            //前端没有提交属性id，则是新增属性
            saveAttrInfoAndValue(baseAttrInfo);
        } else {
            //前端提交属性id，则是修改属性
            updateAttrInfoAndValue(baseAttrInfo);
        }
    }

    @Override
    public void updateAttrInfoAndValue(BaseAttrInfo baseAttrInfo) {
        //1、修改属性。
        baseAttrInfoMapper.updateById(baseAttrInfo);
        //3)、从提交的数据里面，对比发现数据库中原纪录此次没提交的id记录，这些id记录还是要删除的
        //3.1、数据库中查出原值，
        // 删除 delete * from base_attr_value where attrId=12 and id not in(59 前端携带了的id);
        List<Long> nodel_vids = new ArrayList<>();
        for (BaseAttrValue value : baseAttrInfo.getAttrValueList()) {
            if (value.getId() != null) {
                nodel_vids.add(value.getId());
            }
        }

        if (nodel_vids.size() > 0) {
            //有东西，说明保留前端的部分数据
            QueryWrapper<BaseAttrValue> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("attr_id", baseAttrInfo.getId());
            queryWrapper.notIn("id", nodel_vids);
            //所有属性值不在前端提交的范围内的都是不要的，删除的
            baseAttrValueMapper.delete(queryWrapper);
        } else {
            //没东西，全删除
            QueryWrapper<BaseAttrValue> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("attr_id", baseAttrInfo.getId());
            baseAttrValueMapper.delete(queryWrapper);
        }
        //2、修改属性值
        List<BaseAttrValue> valueList = baseAttrInfo.getAttrValueList();
        for (BaseAttrValue value : valueList) {
            //1)、有id的属性值，直接改 base_attr_value
            if (value.getId() != null) {
                baseAttrValueMapper.updateById(value);
            }

            //2)、无id的属性值，是新增 base_attr_value
            if (value.getId() == null) {
                //新增要回填属性id
                value.setAttrId(baseAttrInfo.getId());
                baseAttrValueMapper.insert(value);
            }
        }

    }

    @Override
    public void saveAttrInfoAndValue(BaseAttrInfo baseAttrInfo) {
        //1、保存属性名信息到 base_attr_info
        baseAttrInfoMapper.insert(baseAttrInfo);

        //2、保存属性值信息到 base_attr_value
        List<BaseAttrValue> attrValueList = baseAttrInfo.getAttrValueList();
        for (BaseAttrValue value : attrValueList) {
            //回填属性id
            Long id = baseAttrInfo.getId(); //属性名的自增id
            value.setAttrId(id);
            baseAttrValueMapper.insert(value);
        }
    }

    @Override
    public List<BaseAttrValue> findAttrValueByAttrId(Long attrId) {

        List<BaseAttrValue> list = baseAttrInfoMapper.findAttrValueByAttrId(attrId);
        return list;
    }
}




