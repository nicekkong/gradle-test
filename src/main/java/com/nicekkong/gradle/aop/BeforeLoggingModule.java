/*
 * Copyright (c) 2015.
 * nicekkong JE Foundation
 */

package com.nicekkong.gradle.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by nicekkong on 2015. 12. 19..
 */
public class BeforeLoggingModule implements MethodBeforeAdvice{

    private static final Logger log = LoggerFactory.getLogger(BeforeLoggingModule.class);

    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        if(log.isDebugEnabled()) {
            log.debug("@@@@(Before) Method classed : " + method.getName());
            if(args.length == 0) {
                log.debug("@@@@(Before) No arguments passed.");
            }
            for(Object arg:args) {
                log.debug("@@@@(Before) Argument passed: " + arg.toString());
            }
        }
    }
}
