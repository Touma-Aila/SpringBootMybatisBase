package com.touma.springbootmybatisbase.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.touma.springbootmybatisbase.dao.TbPageInfoDAO;
import com.touma.springbootmybatisbase.entity.TbPageInfo;
import com.touma.springbootmybatisbase.model.PageInfoModel;
import com.touma.springbootmybatisbase.service.PageInfoService;
import com.touma.springbootmybatisbase.utils.JsonMessage;

/**
 * -TbPageInfo服务层
 * 
 * @author 1329321290
 *
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class PageInfoServiceImpl implements PageInfoService {

  @Autowired
  private TbPageInfoDAO tbPageInfoDAO;

  @Override
  public JsonMessage queryAll(PageInfoModel model) throws Exception {
    JsonMessage message = JsonMessage.getSuccess("");
    PageHelper.startPage(model.getPage().getPageNumber(), model.getPage().getPageSize());
    Page<TbPageInfo> list = (Page<TbPageInfo>) tbPageInfoDAO.queryAll();
    model.getPage().setPageInfo(list);
    message.getDatas().put("page", model.getPage());
    message.getDatas().put("list", list);
    return message;
  }

  @Override
  public JsonMessage queryByKey(PageInfoModel model) throws Exception {
    JsonMessage message=JsonMessage.getSuccess("");
    message.getDatas().put("info", tbPageInfoDAO.queryByKey(model.getTbPageInfo()));
    return message;
  }

  @Override
  public JsonMessage add(PageInfoModel model) throws Exception {
    int result=tbPageInfoDAO.add(model.getTbPageInfo());
    return result==1?JsonMessage.getSuccess("添加成功!"):JsonMessage.getFail("添加失败!");
  }

  @Override
  public JsonMessage modify(PageInfoModel model) throws Exception {
    int result=tbPageInfoDAO.modify(model.getTbPageInfo());
    return result==1?JsonMessage.getSuccess("修改成功!"):JsonMessage.getFail("修改失败!");
  }

  @Override
  public JsonMessage delete(PageInfoModel model) throws Exception {
    tbPageInfoDAO.delete(model.getTbPageInfo());
    return JsonMessage.getSuccess("删除成功!");
  }

}
