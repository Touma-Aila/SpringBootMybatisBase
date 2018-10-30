package com.touma.springbootmybatisbase.service;

import com.touma.springbootmybatisbase.entity.TbTokenInfo;
import com.touma.springbootmybatisbase.model.UtilModel;

/**
 * 
 * @author 1329321290
 *
 */
public interface UtilService {

  /**
   * -生成图片校验码
   * 
   * @param model
   * @return
   * @throws Exception
   */
  String makecode(UtilModel model) throws Exception;

  /**
   * -校验图片校验码是否正确 并只能使用一次
   * 
   * @param tokenInfo
   * @return
   * @throws Exception
   */
  boolean checkImageCode(TbTokenInfo tokenInfo) throws Exception;

}
