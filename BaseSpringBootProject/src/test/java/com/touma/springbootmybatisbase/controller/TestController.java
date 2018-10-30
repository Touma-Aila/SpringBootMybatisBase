package com.touma.springbootmybatisbase.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.touma.springbootmybatisbase.base.NeedLogin;
import com.touma.springbootmybatisbase.entity.TbUser;
import com.touma.springbootmybatisbase.model.TestModel;
import com.touma.springbootmybatisbase.utils.JsonMessage;

/**
 * -测试用户登录信息
 * 
 * @author 1329321290
 *
 */
@RestController
@RequestMapping("/test")
public class TestController implements NeedLogin {

  private TbUser user;

  @Override
  public void setUser(TbUser user) {
    this.user = user;
  }

  /**
   * -测试NeedLogin接口
   * 
   * @param model
   * @return
   * @throws Exception
   */
  @RequestMapping("/index")
  public JsonMessage index(TestModel model) throws Exception {
    // http://127.0.0.1:20000/test/index?token=
    JsonMessage message = JsonMessage.getSuccess("测试NeedLogin接口");
    // 可以直接拿到登录的user信息
    message.getDatas().put("user", user);
    return message;
  }

}
