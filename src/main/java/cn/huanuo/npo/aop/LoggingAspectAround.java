package cn.huanuo.npo.aop;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Order(2)
@Aspect
@Component
public class LoggingAspectAround {
    private Logger logger = LogManager.getLogger(LoggingAspectAround.class);


    /**
     * 定义一个方法, 用于声明切入点表达式. 一般地, 该方法中再不需要添入其他的代码.
     * 使用 @Pointcut 来声明切入点表达式.
     * 后面的其他通知直接使用方法名来引用当前的切入点表达式.
     */

    @Pointcut("execution(int cn.huanuo..*.*(..))")
    public void jointPoint() {
    }


    @Around("jointPoint()")
    public Object around(ProceedingJoinPoint pjp) {

        List args = Arrays.asList(pjp.getArgs());
        String methodName = pjp.getSignature().getName();
        Object res = null;

        try {
            //before
            logger.debug("the method" + methodName + " begin with " + args);
            res = pjp.proceed();
            //return
            logger.debug("the method" + methodName + " return" + res);

        } catch (Throwable e) {
            //exception
            logger.debug("the method " + methodName + "occurs exception" + e.getMessage());
            throw new RuntimeException();
        } finally {

            //after
            logger.debug("the method " + methodName + "end");
            return res;
        }


    }

}
