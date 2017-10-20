package com.xjp.authc.config;

import com.xjp.authc.util.RedisUtil;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ${DESCRIPTION}
 *
 * @author xujiping 2017-10-19 14:47
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class RedisTest {

  @Autowired
  private RedisConfig redisConfig;

  @Autowired
  private RedisUtil redisUtil;

  @Test
  public void getConfig(){
    int active = redisConfig.getPoolMaxActive();
    System.out.println("max-idle:" + active);
  }

  @Test
  public void testRedisUtil(){
    redisUtil.set("name", "xjp");
    System.out.println("读取redis：" + redisUtil.get("name"));
  }

}
