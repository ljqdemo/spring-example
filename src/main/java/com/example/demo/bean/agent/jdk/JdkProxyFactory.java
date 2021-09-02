package com.example.demo.bean.agent.jdk;

import java.lang.reflect.Proxy;

/**
 * 代理工厂
 */
public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                // 目标类的类加载
                target.getClass().getClassLoader(),
                // 代理需要实现的接口，可指定多个
                target.getClass().getInterfaces(),
                // 代理对象对应的自定义 InvocationHandler
                new DebugInvocationHandler(target)
        );

    }
}
