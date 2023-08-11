package com.example.applicationContext;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.boot.web.servlet.context.AnnotationConfigServletWebServerApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.util.Arrays;

/**
 * @author : KaelvihN
 * @date : 2023/8/10 12:47
 */
public class ApplicationContextAccomplish {
    public static void main(String[] args) {
//        testClassPathApplicationContext();
//        testFileSystemXmlApplicationContext();
//        principleClassPathApplicationContext();
//        testAnnotationConfigApplicationContext();
        testAnnotationConfigServletWebServerApplicationContext();
    }


    /**
     * 基于classpath下的xml创建容器
     */
    public static void testClassPathApplicationContext() {
        ClassPathXmlApplicationContext context
                = new ClassPathXmlApplicationContext("bean.xml");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        Bean2 bean2 = (Bean2) context.getBean("bean2");
        Bean1 bean1 = bean2.getBean1();
        System.out.println("bean1 = " + bean1);
    }

    public static void principleClassPathApplicationContext() {
        /**
         * BeanFactory的一个实现类
         */
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        System.out.println("读取xml前");
        Arrays.stream(beanFactory.getBeanDefinitionNames())
                .forEach(System.out::println);
        /**
         * 读取xml中的bean到beanFactory
         */
        XmlBeanDefinitionReader xmlReader = new XmlBeanDefinitionReader(beanFactory);
        xmlReader.loadBeanDefinitions(new ClassPathResource("bean.xml"));
        System.out.println("读取xml后");
        Arrays.stream(beanFactory.getBeanDefinitionNames())
                .forEach(System.out::println);
    }

    /**
     * 基于磁盘路径下的配置文件来创建
     */
    public static void testFileSystemXmlApplicationContext() {
        /**
         * 绝对路径
         */
        FileSystemXmlApplicationContext context
                = new FileSystemXmlApplicationContext("D:\\IDEA\\IdeaJava\\iocAccomplish\\src\\main\\resources\\bean.xml");
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
        Bean2 bean2 = (Bean2) context.getBean("bean2");
        Bean1 bean1 = bean2.getBean1();
        System.out.println("bean1 = " + bean1);

        /**
         * 相对路径
         */
        FileSystemXmlApplicationContext context1
                = new FileSystemXmlApplicationContext("src\\main\\resources\\bean.xml");
        Arrays.stream(context1.getBeanDefinitionNames())
                .forEach(System.out::println);
        Bean2 bean2_1 = (Bean2) context.getBean("bean2");
        Bean1 bean1_1 = bean2_1.getBean1();
        System.out.println("bean1_1 = " + bean1_1);
    }

    /**
     * 基于java config来创建，适用于web环境
     */
    public static void testAnnotationConfigApplicationContext() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        Arrays.stream(context.getBeanDefinitionNames())
                .forEach(System.out::println);
    }


    public static void testAnnotationConfigServletWebServerApplicationContext() {
        AnnotationConfigServletWebServerApplicationContext context =
                new AnnotationConfigServletWebServerApplicationContext(WebConfig.class);

    }
}
