package com.touma.springbootmybatisbase.dao;

import org.apache.ibatis.annotations.Mapper;

import com.touma.springbootmybatisbase.entity.TbToken;
import com.touma.springbootmybatisbase.entity.TbTokenInfo;

/**
 * 
 * @author 1329321290
 *
 */
@Mapper
public interface TestDAO {
  /**
   * -添加tokeninfo
   * 
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int addTokenInfo(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -添加token
   * 
   * @param token
   * @return
   * @throws Exception
   */
  int addToken(TbToken token) throws Exception;
}
