package com.readandwrite.demo.config;

import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DataSourceAop {

    @Pointcut("!@annotation(com.readandwrite.demo.service.Master) " +
            "&& (execution(* com.readandwrite.demo.service..*.select*(..)) " +
            "|| execution(* com.readandwrite.demo.service..*.get*(..)))")
    public void readPointcut() {

    }

    @Pointcut("@annotation(com.readandwrite.demo.service.Master) " +
            "|| execution(* com.readandwrite.demo.service..*.insert*(..)) " +
            "|| execution(* com.readandwrite.demo.service..*.add*(..)) " +
            "|| execution(* com.readandwrite.demo.service..*.update*(..)) " +
            "|| execution(* com.readandwrite.demo.service..*.edit*(..)) " +
            "|| execution(* com.readandwrite.demo.service..*.delete*(..)) " +
            "|| execution(* com.readandwrite.demo.service..*.remove*(..))")
    public void writePointcut() {

    }

    @Before("readPointcut()")
    public void read() {
        DBContextHolder.slave();
    }

    @Before("writePointcut()")
    public void write() {
        DBContextHolder.master();
    }


    /**
     * 另一种写法：if...else...  判断哪些需要读从数据库，其余的走主数据库
     */
//    @Before("execution(* com.cjs.example.service.impl.*.*(..))")
//    public void before(JoinPoint jp) {
//        String methodName = jp.getSignature().getName();
//
//        if (StringUtils.startsWithAny(methodName, "get", "select", "find")) {
//            DBContextHolder.slave();
//        }else {
//            DBContextHolder.master();
//        }
//    }
}