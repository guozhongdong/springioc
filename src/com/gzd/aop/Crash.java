package com.gzd.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by gzd on 2017/5/20.
 * 验证aop的增强类
 */
public class Crash {

    /*在增强类方法之前执行*/
    public void crash(){
        System.out.println("支付...........");
    }

    /*在增强类方法之后执行*/
    public void after(){

        System.out.println("方法执行之后.......");
    }

    public void round(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("环绕方法前......");
        proceedingJoinPoint.proceed();
        System.out.println("环绕方法后......");

    }
}
