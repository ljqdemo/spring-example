package com.example.demo.bean.agent.cglib;

/**
 * 被代理对象
 */
public class AliSmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
