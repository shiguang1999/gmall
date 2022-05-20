package com.atguigu.gmall.annotation;


import com.atguigu.gmall.exception.AppGlobalExecption;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Import(AppGlobalExecption.class)
@Inherited
public @interface EnableAutoHandleException {


}
