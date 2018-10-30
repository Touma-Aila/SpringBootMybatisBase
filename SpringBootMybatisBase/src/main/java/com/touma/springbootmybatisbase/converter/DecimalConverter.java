package com.touma.springbootmybatisbase.converter;

import java.math.BigDecimal;

import org.springframework.core.convert.converter.Converter;

import com.touma.springbootmybatisbase.utils.MyUtils;

/**
 * BigDecimal-字符转换
 * 
 * @author 1329321290
 *
 */
public class DecimalConverter implements Converter<String, BigDecimal> {
  @Override
  public BigDecimal convert(String source) {
    if (MyUtils.isEmpty(source)) {
      return null;
    }
    source = MyUtils.trim(source);
    try {
      return new BigDecimal(source);
    } catch (Exception ex) {

    }
    return null;
  }
}
