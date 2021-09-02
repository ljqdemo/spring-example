package com.example.demo.bean.reflection;

public class TargetObject {
    private String value;

    public TargetObject() {
        value = "JavaGuide";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }

    private void sout(String a,String b){
        System.out.println("invoke sout result:"+a+b);
    }
}
