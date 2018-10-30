package com.touma.springbootmybatisbase.converter;

import org.springframework.core.convert.converter.Converter;

import com.touma.springbootmybatisbase.utils.MyUtils;

/**
 * Integer数值转换器
 * 
 * @author 1329321290
 *
 */
public class IntegerConverter implements Converter<String, Integer> {
  @Override
  public Integer convert(String source) {
    if (MyUtils.isEmpty(source)) {
      return null;
    }
    source=MyUtils.trim(source);
    try {
      return Integer.parseInt(source);
    } catch (Exception e) {

    }
    return null;
  }
}
