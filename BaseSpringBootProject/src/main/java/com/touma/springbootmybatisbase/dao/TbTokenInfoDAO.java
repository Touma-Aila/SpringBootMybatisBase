package com.touma.springbootmybatisbase.dao;

import org.apache.ibatis.annotations.Mapper;

import com.touma.springbootmybatisbase.entity.TbTokenInfo;

/**
 * 
 * @author 1329321290
 *
 */
@Mapper
public interface TbTokenInfoDAO {
  /**
   * -删除所有过期的TokenInfo
   * 
   * @return
   * @throws Exception
   */
  int deleteTokenInfos() throws Exception;

  /**
   * -添加图形校验码
   * 
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int addImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -查询图形校验码
   * 
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  TbTokenInfo queryImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -更新图形校验码
   * 
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int updateImageCode(TbTokenInfo tokenInfo) throws Exception;

  /**
   * -删除图形校验码
   * 
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  int deleteImageCode(TbTokenInfo tokenInfo) throws Exception;
}
