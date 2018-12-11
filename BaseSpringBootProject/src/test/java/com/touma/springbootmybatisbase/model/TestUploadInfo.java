package com.touma.springbootmybatisbase.model;

import com.touma.springbootmybatisbase.base.BaseEntity;

/**
 * -TbPageInfo模型层
 * 
 * @author 1329321290
 *
 */
public class TestUploadInfo extends BaseEntity {

  private static final long serialVersionUID = -4582525688690268174L;

  private String mime;
  private String filename;
  private long filesize;
  private String url;

  public TestUploadInfo() {

  }

  public String getMime() {
    return mime;
  }

  public void setMime(String mime) {
    this.mime = mime;
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(String filename) {
    this.filename = filename;
  }

  public long getFilesize() {
    return filesize;
  }

  public void setFilesize(long filesize) {
    this.filesize = filesize;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }
}
