package com.atguigu.gmall.exception;


import com.atguigu.gmall.common.execption.GmallException;
import com.atguigu.gmall.common.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice //全局异常处理异常
public class AppGlobalExecption {
    @Value("${spring.application.name}")
    String applicationName;

    @ExceptionHandler(GmallException.class)
    public Result handleGmallException(GmallException exception) {
        log.error("全局异常捕获:业务异常:{}",exception);
        Result fail = Result.fail();
        fail.setCode(exception.getCode());
        fail.setMessage(exception.getMessage());

        //异常的常用信息
        //1、请求
        //2、参数
        //获取当前请求信息
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        //1、得到请求路径
        StringBuffer url = request.getRequestURL();
        //2、得到请求的所有参数
        Map<String, String[]> map = request.getParameterMap();

        Map<String,Object> reqInfo = new HashMap<>();
        reqInfo.put("path",url);
        reqInfo.put("params",map);
        reqInfo.put("serviceName",applicationName);

        fail.setData(reqInfo);
        return Result.fail();

    }

    @ExceptionHandler(Exception.class)
    public Result handleOthreException(Exception exception) {
        log.error("全局异常捕获:系统异常:{}",exception);
        Result fail = Result.fail();
        fail.setCode(500);
        fail.setMessage("服务器内部异常");
        return Result.fail();
    }


}
