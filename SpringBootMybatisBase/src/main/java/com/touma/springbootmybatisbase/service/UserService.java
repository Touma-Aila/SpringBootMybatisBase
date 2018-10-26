package com.touma.springbootmybatisbase.service;

import com.touma.springbootmybatisbase.model.UserModel;
import com.touma.springbootmybatisbase.utils.JsonMessage;

/**
 * 
 * @author 1329321290
 *
 */
public interface UserService {

  /**
   * -用户登录
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage login(UserModel model) throws Exception;

  /**
   * -用户注销
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage logout(UserModel model) throws Exception;

  /**
   * -获取token中的用户信息
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage getUserInfo(UserModel model) throws Exception;

}
