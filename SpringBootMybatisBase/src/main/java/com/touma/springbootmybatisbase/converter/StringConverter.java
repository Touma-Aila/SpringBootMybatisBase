package com.touma.springbootmybatisbase.converter;

import org.springframework.core.convert.converter.Converter;

import com.touma.springbootmybatisbase.utils.MyUtils;

/**
 * -字符转换器
 * 
 * @author 1329321290
 *
 */
public class StringConverter implements Converter<String, String> {
  
  @Override
  public String convert(String source) {
    return MyUtils.trim(source);
  }
}
