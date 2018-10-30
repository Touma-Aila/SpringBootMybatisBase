package com.touma.springbootmybatisbase.base;

import com.touma.springbootmybatisbase.base.BaseEntity;
import com.touma.springbootmybatisbase.entity.TbToken;
import com.touma.springbootmybatisbase.entity.TbTokenInfo;

/**
 * model层 获取客户端 基础类
 * 
 * @author 1329321290
 *
 */
public abstract class BaseModel extends BaseEntity {

  private static final long serialVersionUID = 3695762903097885771L;
  /**
   * token 客户端标志 有服务器端管理 客户端每次都需要提交该数据
   */
  private String token;

  public BaseModel() {

  }

  public String getToken() {
    return token;
  }

  public BaseModel(String token) {
    this.token = token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  /**
   * -getToken的委托方法 将客户端获取的信息传递给Token对象
   * 
   * @return
   */
  public TbToken makeTokenInfo() {
    TbToken tbToken = new TbToken();
    tbToken.setToken(token);
    return tbToken;
  }
  
  /**
   * -getToken的委托方法 将客户端获取的信息传递给Token对象
   * @return
   */
  public TbToken makeTbToken() {
    TbToken tbToken = new TbToken();
    tbToken.setToken(token);
    return tbToken;
  }
  
  /**
   * -在获取tokeninfo的委托方法
   * @return
   */
  public TbTokenInfo makeTbTokenInfo() {
    TbTokenInfo tokenInfo=new TbTokenInfo();
    tokenInfo.setToken(token);
    return tokenInfo;
  }
}
