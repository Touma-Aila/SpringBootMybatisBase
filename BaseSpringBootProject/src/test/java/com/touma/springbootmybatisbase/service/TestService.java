package com.touma.springbootmybatisbase.service;

import com.touma.springbootmybatisbase.model.TestModel;
import com.touma.springbootmybatisbase.utils.JsonMessage;

/**
 * 
 * @author 1329321290
 *
 */
public interface TestService {

  /**
   * -测试事务添加
   * 
   * @param model
   * @return
   * @throws Exception
   */
  JsonMessage tranAdd(TestModel model) throws Exception;

}
