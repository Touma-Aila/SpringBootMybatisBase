package com.touma.springbootmybatisbase.entity;

import java.util.Date;

import com.touma.springbootmybatisbase.base.BaseEntity;

/**
 * TbConfig-实体类
 * 
 * @author 1329321290
 *
 */
public class TbTokenInfo extends BaseEntity {

  private static final long serialVersionUID = -8470280150998770125L;

  private String token;
  private String infoKey;
  private String info;
  private Date lastupdate;

  public TbTokenInfo() {

  }

  public TbTokenInfo(String token, String infoKey, String info, Date lastupdate) {
    this.token = token;
    this.infoKey = infoKey;
    this.info = info;
    this.lastupdate = lastupdate;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getInfoKey() {
    return infoKey;
  }

  public void setInfoKey(String infoKey) {
    this.infoKey = infoKey;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}
