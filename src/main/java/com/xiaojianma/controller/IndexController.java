package com.xiaojianma.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description: 获取域名
 * @Author: xiaojianma
 * @Date: 2020/11/2 22:50
 */
@RestController
public class IndexController {

    @Value("${xiaojianma.url}")
    private String url;


    @RequestMapping("/getUrl")
    public String getUrl() {
        return url;
    }
}
