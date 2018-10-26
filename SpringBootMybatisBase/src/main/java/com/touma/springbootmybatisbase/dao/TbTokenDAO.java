package com.touma.springbootmybatisbase.dao;

import org.apache.ibatis.annotations.Mapper;

import com.touma.springbootmybatisbase.entity.TbToken;

/**
 * TokenDAO-token的dao层
 * 
 * @author 1329321290
 *
 */
@Mapper
public interface TbTokenDAO {
  /**
   * -查询token
   * 
   * @param token
   * @return
   * @throws Exception
   */
  TbToken queryToken(TbToken token) throws Exception;

  /**
   * -添加token
   * 
   * @param token
   * @return
   * @throws Exception
   */
  int addToken(TbToken token) throws Exception;

  /**
   * 更新token
   * 
   * @param token
   * @return
   * @throws Exception
   */
  int updateToken(TbToken token) throws Exception;

  /**
   * -删除token
   * 
   * @param token
   * @return
   * @throws Exception
   */
  int deleteTokens() throws Exception;

  /**
   * -用户上线
   * 
   * @param token
   * @return
   * @throws Exception
   */
  int userLogin(TbToken token) throws Exception;

  /**
   * -用户下线
   * 
   * @param token
   * @return
   * @throws Exception
   */
  int userLogout(TbToken token) throws Exception;
}
