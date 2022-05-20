package com.atguigu.gmall.annotation;


import com.atguigu.gmall.config.Swagger2Config;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Import(Swagger2Config.class)
@Inherited
public @interface EnableAppSwaggerApi {
}
