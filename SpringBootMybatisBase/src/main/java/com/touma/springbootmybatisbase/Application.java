package com.touma.springbootmybatisbase;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * springboot启动类
 * 
 * @author 1329321290
 *
 */
@SpringBootApplication
@EnableScheduling
public class Application {
  public static void main(String[] args) {
    //启动springboot应用
    SpringApplication.run(Application.class, args);
  }
}