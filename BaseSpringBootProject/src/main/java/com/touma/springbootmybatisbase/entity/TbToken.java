package com.touma.springbootmybatisbase.entity;

import java.util.Date;

import com.touma.springbootmybatisbase.base.BaseEntity;

/**
 * entitybase-实体层标准
 * 
 * @author 1329321290
 *
 */
public class TbToken extends BaseEntity {
  private static final long serialVersionUID = 6448483160916127686L;

  private String token;
  private Integer uid;
  private Date lastupdate;

  public TbToken() {

  }

  public TbToken(String token, Integer uid, Date lastupdate) {
    super();
    this.token = token;
    this.uid = uid;
    this.lastupdate = lastupdate;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}
