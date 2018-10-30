package com.touma.springbootmybatisbase.aop;

import org.aspectj.lang.annotation.Pointcut;

/**
 * -应用程序切点定义
 * @author 1329321290
 *
 */
public class AppPointCut {
  @Pointcut("execution(public * com.touma.springbootmybatisbase.controller..*.*(..))")
  public void controller() {
    
  }
}
