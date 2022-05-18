package com.atguigu.gmall.product.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author shiguang
 * @data 22/5/17
 */
@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(){

        return  "hello";
    }
}
