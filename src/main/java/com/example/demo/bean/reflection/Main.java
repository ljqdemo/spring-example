package com.example.demo.bean.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author gino
 * 2021-09-02
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        Class<?> tagetClass = Class.forName("com.example.demo.bean.reflection.TargetObject");
        TargetObject targetObject= ( TargetObject )tagetClass.newInstance();
        //通过calss对象获取所有的方法、
        Method[] methods = tagetClass.getMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        /**
         * 获取指定的方法、
         *
         */
        Method sout = tagetClass.getDeclaredMethod("sout", String.class
                , String.class);
        //手动设置为true 才能调用私有方法
        sout.setAccessible(true);
        //调用方法对象
        sout.invoke(targetObject,"aaa","bbb");


        /**
         * 获取指定方法并调用
         */
        Method publicMethod = tagetClass.getDeclaredMethod("publicMethod",
                String.class);

        publicMethod.invoke(targetObject, "JavaGuide");
        /**
         * 获取指定参数并对参数进行修改
         */
        Field field = tagetClass.getDeclaredField("value");
        //为了对类中的参数进行修改我们取消安全检查
        field.setAccessible(true);
        field.set(targetObject, "JavaGuide1");
        /**
         * 调用 private 方法
         */
        Method privateMethod = tagetClass.getDeclaredMethod("privateMethod");
        //为了调用private方法我们取消安全检查
        privateMethod.setAccessible(true);
        privateMethod.invoke(targetObject);
    }
}
