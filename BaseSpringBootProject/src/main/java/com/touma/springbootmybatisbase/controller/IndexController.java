package com.touma.springbootmybatisbase.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.touma.springbootmybatisbase.model.IndexModel;
import com.touma.springbootmybatisbase.service.IndexService;
import com.touma.springbootmybatisbase.utils.JsonMessage;

/**
 * -首页
 * @author 1329321290
 *
 */
@RestController
public class IndexController {
  
  @Autowired
  private IndexService indexService;
  
  @RequestMapping("")
  public JsonMessage index(IndexModel model) throws Exception {
    //http://127.0.0.1:20000?echo=abc-123
    return indexService.index(model);
  }
}
