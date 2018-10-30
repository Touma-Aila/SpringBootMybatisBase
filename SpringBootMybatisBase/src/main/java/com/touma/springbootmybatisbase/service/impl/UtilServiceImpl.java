package com.touma.springbootmybatisbase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.touma.springbootmybatisbase.dao.TbTokenInfoDAO;
import com.touma.springbootmybatisbase.entity.TbTokenInfo;
import com.touma.springbootmybatisbase.model.UtilModel;
import com.touma.springbootmybatisbase.service.UtilService;
import com.touma.springbootmybatisbase.utils.ImageCode;
import com.touma.springbootmybatisbase.utils.MyUtils;

/**
 * -图片校验码
 * 
 * @author 1329321290
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UtilServiceImpl implements UtilService {

  @Autowired
  private TbTokenInfoDAO tokenInfoDAO;

  @Override
  public String makecode(UtilModel model) throws Exception {
    // 产生图片校验码
    String code = ImageCode.makeCode();
    // 获取token信息
    TbTokenInfo tokenInfo = model.makeTbTokenInfo();
    // 判断图片校验码是否存在
    TbTokenInfo sInfo = tokenInfoDAO.queryImageCode(tokenInfo);
    if (sInfo == null) {
      // 不存在就将图片code写入
      tokenInfo.setInfo(code);
      tokenInfoDAO.addImageCode(tokenInfo);
    } else {
      // 存在就更新图片code
      tokenInfo.setInfo(code);
      tokenInfoDAO.updateImageCode(sInfo);
    }
    return code;
  }

  @Override
  public boolean checkImageCode(TbTokenInfo tokenInfo) throws Exception {
    if (MyUtils.isEmpty(tokenInfo.getInfo())) {
      return false;
    }
    // 获取数据库中的code
    TbTokenInfo sInfo = tokenInfoDAO.queryImageCode(tokenInfo);
    if (sInfo == null) {
      return false;
    }
    // 删除数据库中额code 只能使用一次
    tokenInfoDAO.deleteImageCode(sInfo);
    // 返回数据库中code和传入的code对比结果
    return sInfo.getInfo().equalsIgnoreCase(tokenInfo.getInfo());
  }
}
