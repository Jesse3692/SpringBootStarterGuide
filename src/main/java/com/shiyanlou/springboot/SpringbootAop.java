package com.shiyanlou.springboot;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

// 声明为切面类
@Aspect
@Component
public class SpringbootAop {

    // 设置切点
    @Pointcut(value = "execution(* com.shiyanlou.springboot..*.run(..))")
    public void aop() {
    }

    @Before("aop()")
    public void before() {
        System.out.println("before: 执行方法之前");
    }

    @After("aop()")
    public void after() {
        System.out.println("after: 执行方法后");
    }

    @AfterReturning("aop()")
    public void afterReturning() {
        System.out.println("afterReturning: 方法返回后");
    }

    @AfterThrowing("aop()")
    public void afterThrowing() {
        System.out.println("afterThrowing: 异常抛出后");
    }

    @Around("aop()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("around: 环绕通知前");
        joinPoint.proceed();
        System.out.println("run 方法执行");
        System.out.println("around: 环绕通知后");
    }
}