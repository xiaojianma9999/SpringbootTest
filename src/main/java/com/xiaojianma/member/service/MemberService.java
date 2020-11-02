package com.xiaojianma.member.service;

import com.xiaojianma.member.mapper.MemberMapper;
import com.xiaojianma.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberService {

    @Autowired
    MemberMapper memberMapper;

    @Autowired
    OrderMapper orderMapper;

    @Transactional()
    public int addUser(String name, Integer age) {
        int res = memberMapper.insertMember(name, age);
        orderMapper.insertMember(name);
        int i = 1 / age;
        return res;
    }
}
