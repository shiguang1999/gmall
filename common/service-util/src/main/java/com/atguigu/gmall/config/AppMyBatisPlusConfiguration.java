package com.atguigu.gmall.config;

import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

//Mybatis配置全部放在这
@EnableTransactionManagement//开启事务管理
@Configuration
public class AppMyBatisPlusConfiguration {

    @Bean
    public MybatisPlusInterceptor interceptor() {
        //mybatisplus总拦截器
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        PaginationInnerInterceptor innerInterceptor = new PaginationInnerInterceptor();
        innerInterceptor.setOverflow(true);
        interceptor.addInnerInterceptor(innerInterceptor);

        return interceptor;
    }
}
