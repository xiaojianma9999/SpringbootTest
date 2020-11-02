package com.xiaojianma;

import com.xiaojianma.config.member.MemberConfig;
import com.xiaojianma.config.order.OrderConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties({MemberConfig.class, OrderConfig.class})
public class MyBatisSpring {

    public static void main(String[] args) {
        SpringApplication.run(MyBatisSpring.class, args);
    }
}
