package com.example.demo.bean.agent.cglib;

import com.example.demo.bean.agent.jdk.JdkProxyFactory;
import com.example.demo.bean.agent.jdk.SmsService;
import com.example.demo.bean.agent.jdk.SmsServiceImpl;

/**
 * @author gino
 * 2021-09-02
 */
public class Test {
    public static void main(String[] args) {
        AliSmsService proxy = (AliSmsService) CglibProxyFactory.getProxy(AliSmsService.class);
        proxy.send("python");
    }
}
