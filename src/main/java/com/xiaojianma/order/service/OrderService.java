package com.xiaojianma.order.service;

import com.xiaojianma.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {
    @Autowired
    OrderMapper orderMapper;

    @Transactional()
    public int addOrder(String number) {
        return orderMapper.insertMember(number);
    }
}
