package com.touma.springbootmybatisbase.model;

import com.touma.springbootmybatisbase.base.BaseModel;
import com.touma.springbootmybatisbase.entity.TbToken;
import com.touma.springbootmybatisbase.entity.TbTokenInfo;

/**
 * -测试用
 * 
 * @author 1329321290
 *
 */
public class TestModel extends BaseModel {

  private static final long serialVersionUID = 5113380562967162762L;

  private TbToken ctoken = new TbToken();

  private TbTokenInfo tokenInfo = new TbTokenInfo();
  
  private String imageCode="";

  public TestModel() {

  }

  public TbToken getCtoken() {
    return ctoken;
  }

  public void setCtoken(TbToken ctoken) {
    this.ctoken = ctoken;
  }

  public TbTokenInfo getTokenInfo() {
    return tokenInfo;
  }

  public void setTokenInfo(TbTokenInfo tokenInfo) {
    this.tokenInfo = tokenInfo;
  }

  public String getImageCode() {
    return imageCode;
  }

  public void setImageCode(String imageCode) {
    this.imageCode = imageCode;
  }

}
