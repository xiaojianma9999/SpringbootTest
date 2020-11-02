package com.xiaojian;

import com.xiaojian.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Description:
 * @Author: xiaojianma
 * @Date: 2020/11/2 23:42
 */
public class SpringTest {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        Object userService = applicationContext.getBean("userService");
        Object orderService = applicationContext.getBean("orderService");
        System.out.println(userService);
        System.out.println(orderService);
    }
}
