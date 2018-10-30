package com.touma.springbootmybatisbase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.touma.springbootmybatisbase.dao.TestDAO;
import com.touma.springbootmybatisbase.model.TestModel;
import com.touma.springbootmybatisbase.service.TestService;
import com.touma.springbootmybatisbase.utils.JsonMessage;

/**
 * 
 * @author 1329321290
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class TestServiceImpl implements TestService{
  
    @Autowired
    private TestDAO testDAO;
    
    @Override
    public JsonMessage tranAdd(TestModel model) throws Exception {
      //事务处理 只要一个失败都会失败 否则
      testDAO.addToken(model.getCtoken());
      testDAO.addTokenInfo(model.getTokenInfo());
      return JsonMessage.getSuccess("添加成功");
    }
}
