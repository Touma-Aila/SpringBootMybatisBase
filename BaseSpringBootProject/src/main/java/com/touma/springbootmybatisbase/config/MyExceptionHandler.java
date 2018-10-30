package com.touma.springbootmybatisbase.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.touma.springbootmybatisbase.exception.AppException;
import com.touma.springbootmybatisbase.utils.JsonMessage;

/**
 * Controller层全局错误处理 <br>
 * ControllerAdvice注解表示是控制器拦截处理(aop-面向切面编程)
 * 
 * @author 1329321290
 *
 */
@ControllerAdvice
@ResponseBody
public class MyExceptionHandler {

  private static final Logger log = LoggerFactory.getLogger(MyExceptionHandler.class);

  @ExceptionHandler(Exception.class)
  public JsonMessage handleException(Exception ex) {
    log.error("服务器发送错误:", ex);
    // 处理应用程序自定义异常
    if (ex instanceof AppException) {
      AppException appException = (AppException) ex;
      return JsonMessage.getFail(appException.getCode(), appException.getMessage());
    }
    if (ex instanceof NoHandlerFoundException) {
      return JsonMessage.getFail(404, "资源不存在");
    }
    return JsonMessage.getFail("服务器繁忙,请稍后再试!");
  }

}
