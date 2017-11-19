package cn.huanuo.npo.aop;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Order(1)
@Aspect
@Component
public class LoggingAspect {
    private Logger logger = LogManager.getLogger(LoggingAspect.class);


    /**
     * 定义一个方法, 用于声明切入点表达式. 一般地, 该方法中再不需要添入其他的代码.
     * 使用 @Pointcut 来声明切入点表达式.
     * 后面的其他通知直接使用方法名来引用当前的切入点表达式.
     */

    @Pointcut("execution(int cn.huanuo..*.*(..))")
    public void jointPoint() {
    }


    /**
     * 每一个方法开始之前执行一段代码
     */

    @Before("jointPoint()")
    public void beforeMethod(JoinPoint JoinPoint) {
        String methodname = JoinPoint.getSignature().getName();
        Object[] args = JoinPoint.getArgs();

        logger.debug("the method " + methodname + " begin with " + Arrays.asList(args));
    }


    /**
     * 在方法执行之后执行的代码. 无论该方法是否出现异常
     */
    @After("jointPoint()")
    public void afterMethod(JoinPoint joinPoint) {
        String methodName = joinPoint.getSignature().getName();
        logger.debug("The method " + methodName + " ends");
    }


    @AfterReturning(value = "jointPoint()",
            returning = "result")
    public void afterReturning(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        logger.debug("The method " + methodName + " ends with " + result);
    }

    @AfterThrowing(value = "jointPoint()",
            throwing = "e")
    public void afterThrowing(JoinPoint joinPoint, Exception e) {
        String methodName = joinPoint.getSignature().getName();
        logger.debug("The method " + methodName + " occurs excetion:" + e);
    }
}
