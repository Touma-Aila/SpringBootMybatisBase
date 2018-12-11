package com.touma.springbootmybatisbase.service;

import com.touma.springbootmybatisbase.model.PageInfoModel;
import com.touma.springbootmybatisbase.utils.JsonMessage;

/**
 * -TbPageInfo服务层
 * 
 * @author 1329321290
 *
 */
public interface PageInfoService {
  /**
   * -分页查询
   * 
   * @param model 模型信息
   * @return json信息
   * @throws Exception 业务异常
   */
  JsonMessage queryAll(PageInfoModel model) throws Exception;

  /**
   * -主键查询
   * 
   * @param model 模型信息
   * @return json信息
   * @throws Exception 业务异常
   */
  JsonMessage queryByKey(PageInfoModel model) throws Exception;

  /**
   * -添加
   * 
   * @param model 模型信息
   * @return json信息
   * @throws Exception 业务异常
   */
  JsonMessage add(PageInfoModel model) throws Exception;

  /**
   * -更新
   * 
   * @param model 模型信息
   * @return json信息
   * @throws Exception 业务异常
   */
  JsonMessage modify(PageInfoModel model) throws Exception;

  /**
   * -删除
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage delete(PageInfoModel model) throws Exception;
}
