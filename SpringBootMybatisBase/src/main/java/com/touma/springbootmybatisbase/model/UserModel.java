package com.touma.springbootmybatisbase.model;

import com.touma.springbootmybatisbase.base.BaseModel;
import com.touma.springbootmybatisbase.entity.TbUser;

/**
 * -UserModel
 * 
 * @author 1329321290
 *
 */
public class UserModel extends BaseModel {

  private static final long serialVersionUID = 7433696087854533149L;

  private TbUser user = new TbUser();

  public UserModel() {

  }

  public UserModel(TbUser user) {
    this.user = user;
  }

  public TbUser getUser() {
    return user;
  }

  public void setUser(TbUser user) {
    this.user = user;
  }
}
