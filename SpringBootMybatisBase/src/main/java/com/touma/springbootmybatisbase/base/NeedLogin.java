package com.touma.springbootmybatisbase.base;

import com.touma.springbootmybatisbase.entity.TbUser;

/**
 * -需要登录的标志接口
 * 
 * @author 1329321290
 *
 */
public interface NeedLogin {

  /**
   * -没有登录的错误代码
   */
  public static final int NOT_LOGIN = 1000;

  /**
   * -传入登录的用户信息
   * 
   * @param user
   */
  public void setUser(TbUser user);
}
