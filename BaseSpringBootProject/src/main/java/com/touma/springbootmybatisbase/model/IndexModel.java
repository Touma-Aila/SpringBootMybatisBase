package com.touma.springbootmybatisbase.model;

import com.touma.springbootmybatisbase.base.BaseEntity;
import com.touma.springbootmybatisbase.base.BaseModel;

/**
 * -首页model层
 * 
 * @author 1329321290
 *
 */
public class IndexModel extends BaseModel{

  private static final long serialVersionUID = 6718522078836187450L;
  
  private String echo;

  public String getEcho() {
    return echo;
  }

  public void setEcho(String echo) {
    this.echo = echo;
  }
}
