package com.touma.springbootmybatisbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.touma.springbootmybatisbase.model.UserModel;
import com.touma.springbootmybatisbase.service.UserService;
import com.touma.springbootmybatisbase.utils.JsonMessage;

/**
 * 
 * @author 1329321290
 *
 */
@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @RequestMapping("/login")
  public JsonMessage login(UserModel model) throws Exception {
    //http://127.0.0.1:20000/user/login?token=ac0ceab7-82bc-49d8-965b-987aec610448&user.username=Touma&user.password=touma123
    //"user.username":"Touma","user.password":"touma123","imageCode":"82wo9"
    return userService.login(model);
  }
  
  @RequestMapping("/logout")
  public JsonMessage logout(UserModel model) throws Exception {
    return userService.logout(model);
  }
  
  @RequestMapping("/getUserInfo")
  public JsonMessage getUserInfo(UserModel model) throws Exception {
    //http://127.0.0.1:20000/user/getUserInfo?token=694632d1-ac0a-47a2-9adb-e54b369b8f7a
    return userService.getUserInfo(model);
  }
}
