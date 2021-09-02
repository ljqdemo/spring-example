package com.example.demo.bean;

import com.sun.xml.internal.ws.util.StringUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author gino
 * 2021-09-01
 */
public class test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<Integer> list = new ArrayList<>();

        list.add(12);
        //这里直接添加会报错
        //list.add("a");
        Class<? extends List> clazz = list.getClass();
        Method add = clazz.getDeclaredMethod("add", Object.class);
        //但是通过反射添加，是可以的
        add.invoke(list, "kl");

        System.out.println(list);
        String a = new String("aa");
        String b = new String("aa");
        System.out.println(a == b);  //双等号 基本类型比较值，引用类型比较对象内存地址
        System.out.println(a.equals(b)); // equals比较值
        String in = "1";
        System.out.println(in instanceof CharSequence);


        //基本类型值传递测试
        System.out.println("pass by value");
        testValue1();
        //基本类型的包装类型也是值传递
        System.out.println("pass by quote");
        test2();
        //引用类型类型 引用传递
        quote();

        StringBuilder stringBuilder = new StringBuilder();

        //equals 建议使用Java.utils.Objects.equals 可以有效避免空指针问题
        System.out.println("equals---------");
        String str = new String("2");
        String str1 = "1";
        System.out.println( Objects.equals(str,str1));

        //Arrays.asList()出来的数据 底层仍然时数组 不能进行add remove 等操作
     /*   List<String> strings = Arrays.asList("1", "2", "3");
        strings.add("4");
*/
        /**
         *  过滤或修改List中的值
         * list 情不要在for循环中 对元素进行remove ,add
         */
        List<Integer> numbers=new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        numbers.add(6);
        // 方式1： list.Ifremove方法过滤数据
        System.out.println(numbers.toString());
        boolean b1 = numbers.removeIf(filter -> filter % 2 != 0);
        System.out.println(numbers.toString());
        //方式2： list 迭代器
        //获取迭代器
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()){
            Integer next = iterator.next();
            //删除条件
            if(next<3){
                iterator.remove();
            }
        }
        System.out.println(numbers);
        //不能直接在for循环中remove 元素  运行时会抛出CurrentModificationException
        /*numbers.forEach(i->{
            if(i>5) {
                numbers.remove(i);
            }
        });
        System.out.println(numbers);*/



    }

    /**
     * java的基本类型是值的传递  个方法不能修改一个基本数据类型的参数 所以调用swa后num1 于num2的值不会变化
     * 相当于a与b是值num1于num2的副本
     */
    public static void testValue1() {
        int num1 = 10;
        int num2 = 20;

        swap(num1, num2);

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
    }

    public static void swap(int a, int b) {
        int temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }

    /***
     * 包装类型也是传递测试
     */
    public static void test2() {
        String num1 = "158";
        String num2 = "258";

        swap2(num1, num2);

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);
    }

    public static void swap2(String a, String b) {
        String temp = a;
        a = b;
        b = temp;

        System.out.println("a = " + a);
        System.out.println("b = " + b);
    }


    /**
     * 引用类型 直接是引用的传递
     */
    public static void quote() {
        String[] arr = {"1", "2", "3"};
        //invokeMethod Before
        System.out.println(arr[0]);
        replaceFirst(arr);
        //invokeMethod After
        System.out.println(arr[0]);
    }

    public static void replaceFirst(String[] array) {
        array[0] = "test";
    }
}
