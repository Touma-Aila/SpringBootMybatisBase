package com.touma.springbootmybatisbase.converter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Controller;

import com.touma.springbootmybatisbase.utils.MyUtils;

/**
 * DateConverter-日期数据转换器
 * 
 * @author 1329321290
 *
 */
@Controller
public class DateConverter implements Converter<String, Date> {

  /**
   * 短日期格式
   */
  private static final SimpleDateFormat SDFSHORT = new SimpleDateFormat("yyyy-MM-dd");

  /**
   * 长日期格式
   */
  private static final SimpleDateFormat SDFLONG = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

  /**
   * 长日期正则
   */
  private static final Pattern PSHORT = Pattern.compile("^\\d{4}[-]\\d{2}[-]\\d{2}$");

  /**
   * 短日期正则
   */
  private static final Pattern PLONG = Pattern.compile("^\\d{4}[-]\\d{2}[-]\\d{2} ^\\d{2}:\\d{2}:\\d{2}");

  @Override
  public Date convert(String source) {
    if (MyUtils.isEmpty(source)) {
      return null;
    }
    source=MyUtils.trim(source);
    try {
      if (PLONG.matcher(source).matches()) {
        // 长日期
        return SDFLONG.parse(source);
      } else if (PSHORT.matcher(source).matches()) {
        // 短日期
        return SDFSHORT.parse(source);
      }
    } catch (Exception ex) {

    }
    return null;
  }

  public static void main(String[] args) {
    // 正则表达式测试 \d是数字 {n,m}是量词 [指定的字符列表] \d也可以是[0123456789] ^是行开头 $是行结尾
    // 四位数-两位数-两位数
    // 如果校验座机号码 {0}\\d{2,3}[-]\\d{7,8}
//    Pattern pattern = Pattern.compile("^\\d{4}[-]\\d{2}[-]\\d{2}$");
//    String info = "123-88-77";
//    System.out.println(pattern.matcher(info).matches());
//    info = "2340-77-99";
//    System.out.println(pattern.matcher(info).matches());
  }

}
