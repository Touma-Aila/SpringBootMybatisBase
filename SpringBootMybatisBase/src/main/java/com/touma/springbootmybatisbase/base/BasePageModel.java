package com.touma.springbootmybatisbase.base;

import com.touma.springbootmybatisbase.utils.PageBean;

/**
 * -带分页的信息model类
 * 
 * @author 1329321290
 *
 */
public class BasePageModel extends BaseModel {

  private static final long serialVersionUID = 2960809097054629425L;

  private PageBean page = new PageBean();

  public BasePageModel() {

  }

  public PageBean getPage() {
    return page;
  }

  public void setPage(PageBean page) {
    this.page = page;
  }
}
