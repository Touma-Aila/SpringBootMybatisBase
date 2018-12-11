package com.touma.springbootmybatisbase.model;

import com.touma.springbootmybatisbase.base.BasePageModel;
import com.touma.springbootmybatisbase.entity.TbPageInfo;

/**
 * -PageInfoModel
 * 
 * @author 1329321290
 *
 */
public class PageInfoModel extends BasePageModel {

  private static final long serialVersionUID = 8115742459889416555L;

  private TbPageInfo tbPageInfo = new TbPageInfo();

  public PageInfoModel() {

  }

  public TbPageInfo getTbPageInfo() {
    return tbPageInfo;
  }

  public void setTbPageInfo(TbPageInfo tbPageInfo) {
    this.tbPageInfo = tbPageInfo;
  }

}
