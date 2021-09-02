package com.example.demo.bean.agent.jdk;

/**
 * @author gino
 * 2021-09-02
 */
public class Test {
    public static void main(String[] args) {
     //动态代理测试
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");

    }
}
