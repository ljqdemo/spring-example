package com.example.demo;

import com.example.demo.bean.Mybean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

@SpringBootTest
class SpringExampleApplicationTests {

    @Test
    void contextLoads() {

        /**
         *  方式一
         *
         *  1步：先将 传入的路径（String）   使用ClassPathResource转成 Resource对象
         *  2步：将Resource 对象通过构造函数  传入 xmlBeaFactory 并初始化 XmlBeanDefinitionReader对象（xml解析器） ，调用xml解析器 解析Resource对象
         *  3步： XmlBeanDefinitionReader中将Resource对象转成EncodedResource对象，
         *          通过EncodeResource对象获取InputStream对象并设置编码，然后将inputStream 进一步解析成Document（此时才真正意义上来解析xml）
         *  4. 通过Document对象 解析完 xml后, 调用registerBeanDefinitions 将解析完的bean注入到容器
         *
         *
         *
         *
         *
         */
        BeanFactory beanFactory=new XmlBeanFactory(new ClassPathResource("test.xml"));
        Mybean mybean= (Mybean) beanFactory.getBean("Mybean");
        System.out.println(mybean.getName());






        //方式二
        BeanFactory beanFactory2= new ClassPathXmlApplicationContext("test.xml");
        Mybean mybean2= (Mybean) beanFactory.getBean("Mybean");
        System.out.println(mybean.equals(mybean2));
    }

}
