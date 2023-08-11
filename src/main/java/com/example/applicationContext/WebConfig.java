package com.example.applicationContext;

import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletRegistrationBean;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.Controller;

/**
 * @author : KaelvihN
 * @date : 2023/8/11 17:46
 */


public class WebConfig {
    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        // 提供内嵌的 Web 容器
        return new TomcatServletWebServerFactory();
    }

    @Bean
    public DispatcherServlet dispatcherServlet() {
        // 添加前控制器
        return new DispatcherServlet();
    }

    @Bean
    public DispatcherServletRegistrationBean dispatcherServletRegistrationBean(DispatcherServlet dispatcherServlet) {
        // 将 DispatcherServlet 注册到 Tomcat 服务器
        return new DispatcherServletRegistrationBean(dispatcherServlet, "/");
    }

    // 如果 bean 以 '/' 开头，将 '/' 后的 bean 的名称作为访问路径
    @Bean("/hello")
    public Controller controller() {
        // 添加控制器，用于展示
        return (request, response) -> {
            response.getWriter().println("hello");
            return null;
        };
    }
}
