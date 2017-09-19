package com.xjp.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.velocity.texen.Generator;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

/*
 * 自动生成mapper、bean等
 * @author xujiping 2017-09-01 14:15
 */

public class MyBatisGeneratorUtil {

  /**
   * main.
   *
   * @param args String[]
   */
  public static void main(String[] args) {
    try {
      List<String> warnings = new ArrayList<String>();
      boolean overwrite = true;
      ConfigurationParser cp = new ConfigurationParser(warnings);
      Configuration config = cp.parseConfiguration(
          Generator.class.getResourceAsStream("/generator/generatorConfig.xml"));
      DefaultShellCallback callback = new DefaultShellCallback(overwrite);
      MyBatisGenerator myBatisGenerator = new MyBatisGenerator(config, callback, warnings);
      myBatisGenerator.generate(null);
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
