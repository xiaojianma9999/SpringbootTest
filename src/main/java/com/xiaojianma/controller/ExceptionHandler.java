package com.xiaojianma.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: 异常切面类
 * @Author: xiaojianma
 * @Date: 2020/11/2 21:51
 */
@ControllerAdvice
public class ExceptionHandler {

    @org.springframework.web.bind.annotation.ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String, String> exceptionHandler() {
        Map<String, String> resMap = new HashMap<>();
        resMap.put("respCode", "500");
        resMap.put("respMsg", "系统错误");
        return resMap;
    }

}
