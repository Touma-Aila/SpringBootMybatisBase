package com.touma.springbootmybatisbase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.touma.springbootmybatisbase.dao.UtilsDAO;
import com.touma.springbootmybatisbase.model.IndexModel;
import com.touma.springbootmybatisbase.service.IndexService;
import com.touma.springbootmybatisbase.utils.JsonMessage;

/**
 * 
 * @author 1329321290
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class IndexServiceImpl implements IndexService{
  @Autowired
  private UtilsDAO utilsDAO;
  
  @Override
  public JsonMessage index(IndexModel model) throws Exception{
    JsonMessage message=JsonMessage.getSuccess(model.getEcho());
    message.getDatas().put("now", utilsDAO.queryTime());
    return message;
  }
}
