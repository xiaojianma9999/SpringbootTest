package com.xiaojianma.controller;

import com.xiaojianma.member.service.MemberService;
import com.xiaojianma.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MybatisController {

    @Autowired
    MemberService memberService;

    @Autowired
    OrderService orderService;

    @RequestMapping("/addUser")
    public String addUser(String name, Integer age) {
        return memberService.addUser(name, age) > 0 ? "success" : "fail";
    }

    @RequestMapping("/addOder")
    public String addOrder(String number) {
        return orderService.addOrder(number) > 0 ? "success" : "fail";
    }
}
