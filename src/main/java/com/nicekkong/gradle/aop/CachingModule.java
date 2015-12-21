/*
 * Copyright (c) 2015.
 * nicekkong JE Foundation
 */

package com.nicekkong.gradle.aop;

import com.nicekkong.gradle.model.Type;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nicekkong on 2015. 12. 21..
 */
public class CachingModule implements MethodInterceptor {

    private static final Logger log = LoggerFactory.getLogger(CachingModule.class);
    private static final Map<String, String> cache = new HashMap<String, String>();

    public Object invoke(MethodInvocation invocation) throws Throwable {

        Object result = null;
        Type documentType = null;

        log.debug("@@@(Caching) review if this call is cachable...");

        if("findByType".equals(invocation.getMethod().getName())
                && invocation.getArguments().length == 1
                && invocation.getArguments()[0] instanceof Type) {
            documentType = (Type)invocation.getArguments()[0];
            log.debug("@@@(Caching) Is cachable~!!");
            if(cache.containsKey(documentType.getName())) {
                log.debug("@@@(Caching) Found in Cache");
                return cache.get(documentType.getName());
            }

            log.debug("@@@(Caching) Not Found! but is chachable!");
            result = invocation.proceed();
            cache.put(documentType.getName(), String.valueOf(result));
            return result;
        }
        return invocation.proceed();
    }
}
