package com.atguigu.gmall.product.config;

import com.atguigu.gmall.config.AppMyBatisPlusConfiguration;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Import(AppMyBatisPlusConfiguration.class)
@MapperScan(basePackages = {"com.atguigu.gmall.product.dao", "com.atguigu.gmall.product.mapper"})
@Configuration
public class AppConfiguration {


}
