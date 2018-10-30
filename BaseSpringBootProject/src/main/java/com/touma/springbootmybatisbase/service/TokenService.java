package com.touma.springbootmybatisbase.service;

import com.touma.springbootmybatisbase.entity.TbToken;

/**
 * -token服务
 * 
 * @author 1329321290
 *
 */
public interface TokenService {

  /**
   * -检查token是否存在 不存在就返回新的
   * 
   * @param token
   * @return
   * @throws Exception
   */
  TbToken checkToken(TbToken token) throws Exception;
  
  /**
   * -删除所有过期token
   * @return
   * @throws Exception
   */
  int deleteTokens() throws Exception;

}
