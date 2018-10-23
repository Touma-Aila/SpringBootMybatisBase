package com.touma.springbootmybatisbase.entity;

import java.util.Date;

import com.touma.springbootmybatisbase.base.BaseEntity;

/**
 * TbTokenInfo-实体类
 * 
 * @author 1329321290
 *
 */
public class TbConfig extends BaseEntity {

  private static final long serialVersionUID = 7865595509087325349L;

  private Integer configKey;
  private Integer configValue;
  private Date lastupdate;

  public TbConfig() {

  }

  public TbConfig(Integer configKey, Integer configValue, Date lastupdate) {
    this.configKey = configKey;
    this.configValue = configValue;
    this.lastupdate = lastupdate;
  }

  public Integer getConfigKey() {
    return configKey;
  }

  public void setConfigKey(Integer configKey) {
    this.configKey = configKey;
  }

  public Integer getConfigValue() {
    return configValue;
  }

  public void setConfigValue(Integer configValue) {
    this.configValue = configValue;
  }

  public Date getLastupdate() {
    return lastupdate;
  }

  public void setLastupdate(Date lastupdate) {
    this.lastupdate = lastupdate;
  }

}
