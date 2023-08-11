package com.example.applicationContext;

import org.springframework.context.annotation.Bean;

/**
 * @author : KaelvihN
 * @date : 2023/8/11 12:46
 */


public class Config {
    @Bean
    public Bean1 bean1() {
        return new Bean1();
    }

    @Bean
    public Bean2 bean2(Bean1 bean1) {
        Bean2 bean2 = new Bean2();
        bean2.setBean1(bean1);
        return bean2;
    }
}
