package com.touma.springbootmybatisbase.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.touma.springbootmybatisbase.entity.TbTokenInfo;
import com.touma.springbootmybatisbase.model.TestModel;
import com.touma.springbootmybatisbase.model.TestUploadInfo;
import com.touma.springbootmybatisbase.service.TestService;
import com.touma.springbootmybatisbase.service.UtilService;
import com.touma.springbootmybatisbase.utils.JsonMessage;

/**
 * -其它测试控制器
 * 
 * @author 1329321290
 *
 */
@RestController
@RequestMapping("/test")
public class TestOtherController {

  /**
   * 文件上传保存路径
   */
  public static final String UPLOAD_DIR = "/uploadfiles";

  /**
   * 文件上传保存完整路径
   */
  private File savePath;

  @Autowired
  private TestService testService;

  @Autowired
  private UtilService utilService;

  public TestOtherController() {
    savePath = new File(System.getProperty("user.dir") + UPLOAD_DIR);
    if (!savePath.exists()) {
      savePath.mkdirs();
    }
  }

  /**
   * -测试事务
   * 
   * @param model
   * @return
   * @throws Exception
   */
  @RequestMapping("/tran")
  public JsonMessage tran(TestModel model) throws Exception {
    // http://127.0.0.1:20000/test/tran?token=&ctoken.token=abcdef&tokenInfo.infokey=abc&tokeninfo.info=dddd
    model.getTokenInfo().setToken(model.getCtoken().getToken());
    return testService.tranAdd(model);
  }

  @RequestMapping("/imageCode")
  public JsonMessage imageCode(TestModel model) throws Exception {
    // http://127.0.0.1:20000/test/imageCode?token=&imageCode=
    // /test/imageCode {"token":"","imageCode":""}
    // 获取图片校验码
    TbTokenInfo info = model.makeTbTokenInfo();
    info.setInfo(model.getImageCode());
    // 校验
    boolean check = utilService.checkImageCode(info);
    if (check) {
      return JsonMessage.getSuccess("图片校验码正确");
    } else {
      return JsonMessage.getFail("图片校验码失败");
    }
  }

  @RequestMapping("/upload")
  public JsonMessage upload(TestModel model, MultipartFile file) throws Exception {
    // 文件上传需要多一个MultipartFile参数来获取表单中的文件上传信息
    if (file == null || file.isEmpty()) {
      return JsonMessage.getFail("选择文件上传");
    }
    // 获取文件上传信息
    TestUploadInfo info = new TestUploadInfo();
    // 上传的文件名
    info.setFilename(file.getOriginalFilename());
    // 上传的文件mime类型
    info.setMime(file.getContentType());
    // 上传的文件大小
    info.setFilesize(file.getSize());
    // 获取文件的扩展名
    String ext = "";
    String strExt = ".";
    if (info.getFilename().indexOf(strExt) > -1) {
      int index = info.getFilename().lastIndexOf(strExt);
      ext = info.getFilename().substring(index);
    }
    // 生成UUID为保存的文件地址
    File savefile = new File(savePath, UUID.randomUUID().toString() + ext);
    // 生成文件的服务器url地址
    info.setUrl(UPLOAD_DIR + savefile.getName());
    // 保存文件
    InputStream is = file.getInputStream();
    OutputStream os = new FileOutputStream(savefile);
    byte[] bytes = new byte[8 * 1024];
    int len = is.read(bytes);
    while (len > 0) {
      os.write(bytes, 0, len);
      os.flush();
      len = is.read();
    }
    os.close();
    is.close();
    // 应答信息
    JsonMessage message = JsonMessage.getSuccess("上传成功");
    message.getDatas().put("uploadinfo", info);
    return message;
  }
}
