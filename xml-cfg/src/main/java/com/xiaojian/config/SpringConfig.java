package com.xiaojian.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Author: xiaojianma
 * @Date: 2020/11/2 23:40
 */
@Configuration
@ComponentScan("com.xiaojian.service")
public class SpringConfig {

    /*@Configuration等同于xml配置 bean.xml*/
}
