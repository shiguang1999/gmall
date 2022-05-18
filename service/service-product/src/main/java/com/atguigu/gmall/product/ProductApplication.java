package com.atguigu.gmall.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author shiguang
 * @data 22/5/17
 */

@MapperScan(basePackages = "com.atguigu.gmall.product.dao" )
@SpringCloudApplication
public class ProductApplication {
    public static void main(String[] args) {

        SpringApplication.run(ProductApplication.class, args);

    }
}
