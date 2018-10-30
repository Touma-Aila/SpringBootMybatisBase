package com.touma.springbootmybatisbase.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.touma.springbootmybatisbase.dao.TbTokenDAO;
import com.touma.springbootmybatisbase.dao.TbTokenInfoDAO;
import com.touma.springbootmybatisbase.entity.TbToken;
import com.touma.springbootmybatisbase.service.TokenService;
import com.touma.springbootmybatisbase.utils.MyUtils;

/**
 * 
 * @author 1329321290
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class TokenServiceImpl implements TokenService {
  @Autowired
  private TbTokenDAO tbTokenDAO;
  @Autowired
  private TbTokenInfoDAO tbTokenInfoDAO;

  /**
   * 创建新的token
   * 
   * @return
   * @throws Exception
   */
  private TbToken newToken() throws Exception {
    TbToken token = new TbToken();
    token.setToken(UUID.randomUUID().toString());
    tbTokenDAO.addToken(token);
    return token;
  }

  @Override
  public TbToken checkToken(TbToken token) throws Exception {
    // 没有就返回新的
    if (token == null || MyUtils.isEmpty(token.getToken())) {
      return newToken();
    }
    // 数据库校验
    TbToken stoken = tbTokenDAO.queryToken(token);
    // 校验不通过就返回新的
    if (stoken == null) {
      return newToken();
    }
    // 通过就更新时间
    tbTokenDAO.updateToken(stoken);
    return stoken;
  }
  
  @Override
  public int deleteTokens() throws Exception {
    //先删除tokeninfo
    tbTokenInfoDAO.deleteTokenInfos();
    //再删除token
    return tbTokenDAO.deleteTokens();
  }
}
