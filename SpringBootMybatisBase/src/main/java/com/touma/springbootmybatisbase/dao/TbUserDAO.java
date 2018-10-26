package com.touma.springbootmybatisbase.dao;

import org.apache.ibatis.annotations.Mapper;

import com.touma.springbootmybatisbase.entity.TbToken;
import com.touma.springbootmybatisbase.entity.TbUser;

/**
 * TbUserDAO-TbUserDAO层
 * 
 * @author 1329321290
 *
 */
@Mapper
public interface TbUserDAO {

  /**
   * 安装用户名查询
   * 
   * @param user
   * @return
   * @throws Exception
   */
  TbUser queryByName(TbUser user) throws Exception;

  /**
   * -查询token中的用户信息
   * 
   * @param token
   * @return
   * @throws Exception
   */
  TbUser queryByToken(TbToken token) throws Exception;
}
