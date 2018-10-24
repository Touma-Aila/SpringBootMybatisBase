package com.touma.springbootmybatisbase.dao;

import java.util.Date;

import org.apache.ibatis.annotations.Mapper;

/**
 * UtilsDAO-工具类DAO
 * 
 * @author 1329321290
 *
 */
@Mapper
public interface UtilsDAO {
  /**
   * -查询当前数据库时间
   * 
   * @return
   * @throws Exception
   */
  Date queryTime() throws Exception;
}
