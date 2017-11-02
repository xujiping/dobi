package com.xjp.client.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * 读取Redis配置.
 *
 * @author xujiping 2017-10-19 14:40
 */
@Configuration
@ConfigurationProperties(prefix = "spring.redis")
public class RedisConfig {

  private static Logger _LOGGER = LoggerFactory.getLogger(RedisConfig.class);

  private String host;

  private int port;

  private String password;

  @Value("${spring.redis.pool.max-active}")
  private int poolMaxActive;

  @Value("${spring.redis.pool.max-wait}")
  private int poolMaxWait;

  @Value("${spring.redis.pool.max-idle}")
  private int poolMaxIdle;

  @Value("${spring.redis.pool.min-idle}")
  private int poolMinIdle;

  private int timeout;

  @Bean
  public JedisPoolConfig getRedisConfig() {
    JedisPoolConfig config = new JedisPoolConfig();
    return config;
  }

  @Bean
  public JedisPool getJedisPool() {
    JedisPoolConfig config = new JedisPoolConfig();
    config.setMaxTotal(poolMaxActive);
    config.setMaxIdle(poolMaxIdle);
    config.setMaxWaitMillis(poolMaxWait);
    // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
    config.setTestOnBorrow(false);
    JedisPool jedisPool = new JedisPool(config, host, port, timeout);
    _LOGGER.info("init JredisPool ...");
    return jedisPool;
  }

  public void setHost(String host) {
    this.host = host;
  }

  public String getHost() {
    return host;
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getPoolMaxActive() {
    return poolMaxActive;
  }

  public void setPoolMaxActive(int poolMaxActive) {
    this.poolMaxActive = poolMaxActive;
  }

  public int getPoolMaxWait() {
    return poolMaxWait;
  }

  public void setPoolMaxWait(int poolMaxWait) {
    this.poolMaxWait = poolMaxWait;
  }

  public int getPoolMaxIdle() {
    return poolMaxIdle;
  }

  public void setPoolMaxIdle(int poolMaxIdle) {
    this.poolMaxIdle = poolMaxIdle;
  }

  public int getPoolMinIdle() {
    return poolMinIdle;
  }

  public void setPoolMinIdle(int poolMinIdle) {
    this.poolMinIdle = poolMinIdle;
  }

  public int getTimeout() {
    return timeout;
  }

  public void setTimeout(int timeout) {
    this.timeout = timeout;
  }
}
