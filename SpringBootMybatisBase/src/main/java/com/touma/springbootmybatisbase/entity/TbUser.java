package com.touma.springbootmybatisbase.entity;

import java.io.Serializable;
import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;
import com.touma.springbootmybatisbase.base.BaseEntity;

/**
 * TbUser表
 * 
 * @author 1329321290
 *
 */
public class TbUser extends BaseEntity{
  private static final long serialVersionUID = 8884493054920090452L;

  private Integer uid;
  private String username;
  private String password;
  private String nickname;
  private String isEnable;
  @JSONField(format = "yyyy年MM月dd月")
  private Date reDate;

  public TbUser() {

  }

  public TbUser(Integer uid, String username, String password, String nickname, String isEnable, Date reDate) {
    this.uid = uid;
    this.username = username;
    this.password = password;
    this.nickname = nickname;
    this.isEnable = isEnable;
    this.reDate = reDate;
  }

  public Integer getUid() {
    return uid;
  }

  public void setUid(Integer uid) {
    this.uid = uid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getIsEnable() {
    return isEnable;
  }

  public void setIsEnable(String isEnable) {
    this.isEnable = isEnable;
  }

  public Date getReDate() {
    return reDate;
  }

  public void setReDate(Date reDate) {
    this.reDate = reDate;
  }

}
