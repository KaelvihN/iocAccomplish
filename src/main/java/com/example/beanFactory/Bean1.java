package com.example.beanFactory;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.annotation.Resource;

/**
 * @author : KaelvihN
 * @date : 2023/8/8 0:30
 */

@Slf4j
public class Bean1 {
    public Bean1() {
        log.info("Bean1的构造器");
    }

    @Resource
    private Bean2 bean2;

    public Bean2 getBean2() {
        log.info("通过Bean1的getBean2() 获得 Bean2对象");
        return bean2;
    }

    @Autowired @Qualifier("bean4")
    @Resource
    private Inner bean3;

    public Inner getInner() {
        return bean3;
    }

}
