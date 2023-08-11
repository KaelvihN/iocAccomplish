package com.example.beanFactory;

import lombok.extern.slf4j.Slf4j;

/**
 * @author : KaelvihN
 * @date : 2023/8/9 17:31
 */

@Slf4j
public class Bean3 implements Inner {
    public Bean3() {
        log.info("Bean3的构造器");
    }
}
