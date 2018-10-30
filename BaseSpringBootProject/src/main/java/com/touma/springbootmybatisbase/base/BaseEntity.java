package com.touma.springbootmybatisbase.base;

import java.io.Serializable;

import com.alibaba.fastjson.JSONObject;

/**
 * Entity类型的对象的基础
 * 
 * @author 1329321290
 *
 */
public abstract class BaseEntity implements Serializable {
  private static final long serialVersionUID = 3528023615854003062L;

  @Override
  public String toString() {
    // 创建fastjson的json对象
    JSONObject json = new JSONObject();
    // 将当前实例以当前类的名称为key放入json对象中
    json.put(this.getClass().getName(), this);
    // 返回json格式字符串
    return json.toString();
  }

}
