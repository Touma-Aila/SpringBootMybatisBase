package com.touma.springbootmybatisbase.utils;

import java.util.HashMap;
import java.util.Map;

import com.touma.springbootmybatisbase.base.BaseEntity;

/**
 * json同意应答格式(只要是数据应答都是用该格式)
 * 
 * @author 1329321290
 *
 */
public class JsonMessage extends BaseEntity {

  private static final long serialVersionUID = 8070854351852044533L;

  /**
   * code 服务器应答代码 200为正确 50为错误 其他为自定义 默认500
   */
  private int code = 500;

  /**
   * message 服务器应答信息 默认为空
   */
  private String message = "";

  /**
   * datas 服务器应答数据的集合
   */
  private Map<String, Object> datas = new HashMap<>();

  /**
   * sucess 服务器是否正确应答 默认为false
   */
  private boolean success = false;
  
  /**
   * 服务器token信息
   */
  private String token;
  
  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  /**
   * getmessage 静态工厂方法 一个jsonMessage的实例
   * 
   * @param success
   * @param code
   * @param message
   * @return
   */
  public static JsonMessage getMessage(boolean success, int code, String message) {
    JsonMessage json = new JsonMessage();
    json.setCode(code);
    json.setSuccess(success);
    json.setMessage(message);
    return json;
  }

  /**
   * getSuccess 委托方法 获取成功的应答
   * 
   * @param message 成功的消息
   * @return
   */
  public static JsonMessage getSuccess(String message) {
    // 成功应答的success为true code为200
    return JsonMessage.getMessage(true, 200, message);
  }

  /**
   * getFail 委托方法 获取指定错误code的失败应答
   * 
   * @param code
   * @param message
   * @return
   */
  public static JsonMessage getFail(int code, String message) {
    // 指定code的错误应答
    return JsonMessage.getMessage(false, code, message);
  }

  /**
   * getFail 错误应答的委托方法
   * 
   * @param message
   * @return
   */
  public static JsonMessage getFail(String message) {
    return JsonMessage.getMessage(false, 500, message);
  }

  public JsonMessage() {

  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Map<String, Object> getDatas() {
    return datas;
  }

  public void setDatas(Map<String, Object> datas) {
    this.datas = datas;
  }

  public boolean isSuccess() {
    return success;
  }

  public void setSuccess(boolean success) {
    this.success = success;
  }

  public JsonMessage(int code, String message, Map<String, Object> datas, boolean success) {
    this.code = code;
    this.message = message;
    this.datas = datas;
    this.success = success;
  }

}
