/*
 * 2015. 12. 21.
 * Properties of nicekkong@gmail.com
 * Copyright (c) JE Foundation
 */

package com.nicekkong.gradle.aop;

import com.nicekkong.gradle.model.Type;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by nicekkong on 2015. 12. 21..
 */

@Component
@Aspect
public class Caching  {

    private static final Logger log = LoggerFactory.getLogger(Caching.class);
    private static final Map<String, Object> cache = new HashMap<String, Object>();

    @Around("execution(* com.nicekkong.gradle.service.SearchEngine.*(..))")
    public Object caching(ProceedingJoinPoint pjp) throws Throwable {

        Object result = null;
        Type documentType = null;

        log.debug("@@@(Caching) review if this call is cachable...");
        if("findByType".equals(pjp.getSignature().getName())    // method 명이 findByType() 이고
                && pjp.getArgs().length == 1 && pjp.getArgs()[0] instanceof Type) { // 파라메터가 1개가 있고 && 파라메터 타입이 Type 이면....
            documentType = (Type)pjp.getArgs()[0];
            log.debug("@@@(Caching) Is cachable!!");
            if(cache.containsKey(documentType.getName())) {
                log.debug("@@@(Caching) Found in Cache!");
                return cache.get(documentType.getName());
            }

            log.debug("@@@(Caching) Not Found! but is cachable!");
            result = pjp.proceed();
            cache.put(documentType.getName(), result);
            return result;
        }
        return pjp.proceed();
    }

}
