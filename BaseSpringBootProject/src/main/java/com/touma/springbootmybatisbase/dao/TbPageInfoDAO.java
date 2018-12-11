package com.touma.springbootmybatisbase.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.touma.springbootmybatisbase.entity.TbPageInfo;

/**
 * -TbPageInfo-DAO层
 * 
 * @author 1329321290
 *
 */
@Mapper
public interface TbPageInfoDAO {
  /**
   * -查询
   * 
   * @return TbPageInfo数据集
   * @throws Exception 查询发生错误
   */
  List<TbPageInfo> queryAll() throws Exception;

  /**
   * -主键查询
   * 
   * @param tbPageInfo 查询信息
   * @return 数据库影响行数
   * @throws Exception 查询发生错误
   */
  TbPageInfo queryByKey(TbPageInfo tbPageInfo) throws Exception;

  /**
   * -添加
   * 
   * @param tbPageInfo 添加信息
   * @return 数据库影响行数
   * @throws Exception 添加发生错误
   */
  int add(TbPageInfo tbPageInfo) throws Exception;

  /**
   * -更新
   * 
   * @param tbPageInfo 更新信息
   * @return 数据库影响行数
   * @throws Exception 更新发生错误
   */
  int modify(TbPageInfo tbPageInfo) throws Exception;

  /**
   * -删除
   * 
   * @param tbPageInfo 更新信息
   * @return 数据库影响行数
   * @throws Exception 删除发生错误
   */
  int delete(TbPageInfo tbPageInfo) throws Exception;
}
