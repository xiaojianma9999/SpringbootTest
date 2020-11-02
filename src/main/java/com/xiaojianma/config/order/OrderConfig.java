package com.xiaojianma.config.order;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Description: 订单配置类
 * @Author: xiaojianma
 * @Date: 2020/11/2 21:51
 */
@ConfigurationProperties(prefix = "spring.datasource.order")
@Data
public class OrderConfig {

    private String url;

    private String username;

    private String password;

    private int borrowConnectionTimeout;

    private int loginTimeout;

    private int maintenanceInterval;

    private int maxIdleTime;

    private int maxLiftTime;

    private int maxPoolSize;

    private int minPoolSize;

    private String uniqueResourceName;

    private String testQuery;

}
