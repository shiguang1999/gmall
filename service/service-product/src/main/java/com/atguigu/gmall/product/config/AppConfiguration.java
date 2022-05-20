package com.atguigu.gmall.product.config;

import com.atguigu.gmall.annotation.EnableAppSwaggerApi;
import com.atguigu.gmall.config.AppMyBatisPlusConfiguration;
import com.atguigu.gmall.annotation.EnableAutoHandleException;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Import(AppMyBatisPlusConfiguration.class)
@MapperScan(basePackages = {"com.atguigu.gmall.product.dao", "com.atguigu.gmall.product.mapper"})
@Configuration
@EnableAutoHandleException
@EnableAppSwaggerApi
public class AppConfiguration {



}
