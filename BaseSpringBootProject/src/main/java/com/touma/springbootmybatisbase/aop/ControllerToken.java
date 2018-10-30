package com.touma.springbootmybatisbase.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.touma.springbootmybatisbase.base.BaseModel;
import com.touma.springbootmybatisbase.base.NeedLogin;
import com.touma.springbootmybatisbase.dao.TbUserDAO;
import com.touma.springbootmybatisbase.entity.TbToken;
import com.touma.springbootmybatisbase.entity.TbUser;
import com.touma.springbootmybatisbase.service.TokenService;
import com.touma.springbootmybatisbase.utils.JsonMessage;

/**
 * 
 * @author 1329321290
 *
 */
@Aspect
@Component
public class ControllerToken extends AppPointCut {

  private static final Logger log = LoggerFactory.getLogger(ControllerToken.class);

  @Autowired
  private TokenService tokenService;

  @Autowired
  private TbUserDAO tbUserDAO;

  public TbToken processToken(ProceedingJoinPoint pjp) throws Exception {
    Object[] args = pjp.getArgs();
    for (Object arg : args) {
      if (arg instanceof BaseModel) {
        // 只有传入数据的model才能处理token任务
        BaseModel model = (BaseModel) arg;
        TbToken token = model.makeTbToken();
        // 检查并更新token信息
        token = tokenService.checkToken(token);
        return token;
      }
    }
    return null;
  }

  /**
   * -处理登录信息
   * 
   * @param pjp
   * @return
   * @throws Exception
   */
  private JsonMessage processLogin(ProceedingJoinPoint pjp) throws Exception {
    // processLogin.getgetTarget方法是获取被切面拦截的对象
    log.debug(String.format("处理%s登录检查", pjp.getTarget().getClass().getName()));
    boolean needlogin = (pjp.getTarget() instanceof NeedLogin);
    // 获取model信息
    BaseModel model = getModel(pjp);
    // 不需要登录直接通过
    if (!needlogin) {
      return null;
    }
    // 需要登录但是没有model直接返回错误
    if (model == null) {
      return JsonMessage.getFail(NeedLogin.NOT_LOGIN, "需要登录");
    }
    // 需要登录的情况
    NeedLogin needLogin = (NeedLogin) pjp.getTarget();
    TbUser user = tbUserDAO.queryByToken(model.makeTbToken());
    // 不存在的情况
    if (user == null) {
      return JsonMessage.getFail(NeedLogin.NOT_LOGIN, "需要登录");
    }
    // 存在就传入
    needLogin.setUser(user);
    return null;
  }

  /**
   * -获取model信息
   * 
   * @param pjp
   * @return
   */
  public BaseModel getModel(ProceedingJoinPoint pjp) {
    Object[] args = pjp.getArgs();
    for (Object arg : args) {
      if (arg instanceof BaseModel) {
        return (BaseModel) arg;
      }
    }
    return null;
  }

  @Around("controller()")
  public Object around(ProceedingJoinPoint pjp) throws Throwable {
    log.debug("控制器切面token处理");
    TbToken token = processToken(pjp);
    log.debug(String.format("token信息:%s", token));
    // 登录检查
    JsonMessage login = processLogin(pjp);
    // 如果有返回值表示检查失败 需要打断流程 不进入切面
    if (login != null) {
      login.setToken(token.getToken());
      return login;
    }
    Object result = pjp.proceed();
    // 如果应答为JsonMessage且token存在就应答回去
    if (token != null && result instanceof JsonMessage) {
      JsonMessage message = (JsonMessage) result;
      message.setToken(token.getToken());
    }

    return result;
  }
}
