package com.xjp.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import tk.mybatis.spring.mapper.MapperScannerConfigurer;

/**
* @author XuJiping E-mail: xjpdyx@hotmail.com
* @version 创建时间：2017年4月17日 下午1:47:27
* MyBatis扫描Mapper接口
*/
@Configuration
public class MyBatisMapperScannerConfiguration {
	
	@Bean
	public MapperScannerConfigurer mapperScannerConfigurer(){
		MapperScannerConfigurer configurer = new MapperScannerConfigurer();
        //获取注入的sqlSessionFactory对象
        configurer.setSqlSessionFactoryBeanName("sqlSessionFactory");
        //指定xml配置文件路径
        configurer.setBasePackage("com.xjp.dao");
        Properties properties = new Properties();
        properties.setProperty("notEmpty", "false");
        properties.setProperty("IDENTITY", "MYSQL");
        configurer.setProperties(properties);
        return configurer;
	}

}
