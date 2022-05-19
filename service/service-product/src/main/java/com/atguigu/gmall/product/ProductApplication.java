package com.atguigu.gmall.product;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;

/**
 * @author shiguang
 * @data 22/5/17
 */

//@EnableTransactionManagement//开启事务管理

@SpringCloudApplication
public class ProductApplication {
    public static void main(String[] args) {

        SpringApplication.run(ProductApplication.class, args);

    }
}
