package com.touma.springbootmybatisbase.controller;

import java.io.OutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.touma.springbootmybatisbase.model.UtilModel;
import com.touma.springbootmybatisbase.service.UtilService;
import com.touma.springbootmybatisbase.utils.ImageCode;

/**
 * -工具类控制器
 * 
 * @author 1329321290
 *
 */
@RestController
@RequestMapping("/util")
public class UtilController {

  @Autowired
  private UtilService utilService;

  @RequestMapping("/validate.jpg")
  public void imageCode(UtilModel model, HttpServletResponse response) throws Exception {
    //http://127.0.0.1:20000/util/validate.jpg?token=
    // 自定义应答类型为图片
    response.setContentType("image/jpeg");
    // 获取图片校验码
    String code = utilService.makecode(model);
    // 将图片通过通过response输出
    OutputStream os = response.getOutputStream();
    ImageIO.write(ImageCode.makeImage(code), "jpeg", os);
    os.close();
  }
}
