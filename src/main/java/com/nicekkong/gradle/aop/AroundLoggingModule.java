/*
 * Copyright (c) 2015.
 * nicekkong JE Foundation
 */

package com.nicekkong.gradle.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by nicekkong on 2015. 12. 20..
 */
public class AroundLoggingModule implements MethodInterceptor {

    private static final Logger log = LoggerFactory.getLogger(AroundLoggingModule.class);

    public Object invoke(MethodInvocation invocation) throws Throwable {

        Object result = null;

        if(log.isDebugEnabled()) {
            log.debug("@@@@(AROUND-BEFORE) Method called : " + invocation.getMethod().getName());
            if(invocation.getArguments().length == 0) {
                log.debug("@@@@(AROUND-BEFORE) No arguments passed.");
            } else {
                for(Object arg : invocation.getArguments()) {
                    log.debug("@@@@(AROUND-BEFORE) Argument passed : " + arg);
                }
            }
        }

        try {
            if(log.isDebugEnabled()) {
                log.debug("@@@(AROUND-PROCESSING) Processing...");
            }

            result = invocation.proceed();

            if(log.isDebugEnabled()) {
                log.debug("@@@(AROUND-AFTER) Result : " + result);
            }

            return result;

        } catch (Exception e) {
            log.error("@@@(AROUND-AFTER) Throws an Exception : " + e.getMessage());
            throw e;
        }
    }
}
