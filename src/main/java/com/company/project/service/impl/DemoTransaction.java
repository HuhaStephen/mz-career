package com.company.project.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoTransaction {

    /**
     * debug下， @Transactional 注解是在什么时候解析的，代理类是啥时候触发生成的
     */
    @Transactional
    public void testTransactionlAnnotation() {

    }

}
