package cn.huanuo.npo.aop;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;


@Aspect
@Component
public class LoggingAspect {
    private Logger logger = LogManager.getLogger(LoggingAspect.class);


    @Before("execution(* cn.huanuo.npo.aop.*.*(..))")
    public void beforeMethod(JoinPoint JoinPoint) {
        String methodname = JoinPoint.getSignature().getName();
        Object[] args = JoinPoint.getArgs();

        logger.debug("the method " + methodname + " begin with " + Arrays.asList(args));
    }
}
