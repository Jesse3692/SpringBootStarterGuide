package com.shiyanlou.springboot;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.interceptor.DefaultTransactionAttribute;
import org.springframework.transaction.interceptor.NameMatchTransactionAttributeSource;
import org.springframework.transaction.interceptor.TransactionInterceptor;

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

    /**
     * 注入事务管理器
     */
    @Autowired
    public PlatformTransactionManager platformTransactionManager;

    /**
     * 设置事务拦截器 transactionInterceptor
     */
    @Bean
    public TransactionInterceptor transactionInterceptor1() {
        // 设置事务属性，可以通过它设置事务的基本属性，如事务是读写事务或者只读事务，事务的超时时间等
        DefaultTransactionAttribute defaultTransactionAttribute = new DefaultTransactionAttribute();
        // 设置只读事务
        defaultTransactionAttribute.setReadOnly(false);
        // 通过方法名匹配事务
        NameMatchTransactionAttributeSource nameMatchTransactionAttributeSource = new NameMatchTransactionAttributeSource();
        // 为 save 方法添加事务，事务属性为 defaultTransactionAttribute 设置的属性
        nameMatchTransactionAttributeSource.addTransactionalMethod("save", defaultTransactionAttribute);
        // 新建一个事务拦截器，使用 platformTransactionManager 作为事务管理器，拦截的方法为
        // nameMatchTransactionAttributeSource中匹配到的方法
        return new TransactionInterceptor(platformTransactionManager, nameMatchTransactionAttributeSource);
    }

    @Bean
    public Advisor advisor() {
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        // execution 表达式，匹配 save方法
        aspectJExpressionPointcut.setExpression("execution(* com.shiyanlou.springboot..*.save(..))");
        // 返回aop切面，切面=切点+通知
        return new DefaultPointcutAdvisor(aspectJExpressionPointcut, transactionInterceptor1());
    }
}