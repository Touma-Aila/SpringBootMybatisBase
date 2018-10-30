package com.touma.springbootmybatisbase.utils;

import com.github.pagehelper.Page;
import com.touma.springbootmybatisbase.base.BaseEntity;

/**
 * PageBean-分页信息
 * 
 * @author 1329321290
 *
 */
public class PageBean extends BaseEntity {

  private static final long serialVersionUID = 6319667015609017633L;
  private int pageSize = 10;
  private int pageNumber = 1;
  private int pageCount = 0;
  private long total = 0;

  public PageBean() {

  }

  /**
   * 设置分页信息
   * 
   * @param page
   */
  public void setPageInfo(Page<?> page) {
    pageCount = page.getPages();
    pageSize = page.getPageSize();
    pageNumber = page.getPageNum();
    total = page.getTotal();
  }

  public PageBean(int pageSize, int pageNumber, int pageCount, long total) {
    this.pageSize = pageSize;
    this.pageNumber = pageNumber;
    this.pageCount = pageCount;
    this.total = total;
  }

  public int getPageSize() {
    return pageSize;
  }

  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }

  public int getPageNumber() {
    return pageNumber;
  }

  public void setPageNumber(int pageNumber) {
    this.pageNumber = pageNumber;
  }

  public int getPageCount() {
    return pageCount;
  }

  public void setPageCount(int pageCount) {
    this.pageCount = pageCount;
  }

  public long getTotal() {
    return total;
  }

  public void setTotal(long total) {
    this.total = total;
  }

}
