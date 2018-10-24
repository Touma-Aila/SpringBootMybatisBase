package com.touma.springbootmybatisbase.service;

import com.touma.springbootmybatisbase.model.IndexModel;
import com.touma.springbootmybatisbase.utils.JsonMessage;

/**
 * -首页服务
 * 
 * @author 1329321290
 *
 */
public interface IndexService {
  /**
   * -首页echo
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage index(IndexModel model) throws Exception;
}
