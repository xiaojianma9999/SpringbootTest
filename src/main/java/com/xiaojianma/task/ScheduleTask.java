package com.xiaojianma.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Description: 任务调度
 * @Author: xiaojianma
 * @Date: 2020/11/2 22:36
 */
@Component
public class ScheduleTask {

    private static final SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    public void reportCurrentTime() {
        System.out.println("现在时间是：" + SIMPLE_DATE_FORMAT.format(new Date()));
    }
}
