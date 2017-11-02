package com.xjp.client.util;

import com.xjp.client.config.RedisConfig;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.locks.ReentrantLock;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Redis 工具类.
 *
 * @author xujiping 2017-10-19 10:35
 */
@Component
public class RedisUtil {

  @Autowired
  private RedisConfig redisConfig;

  protected static ReentrantLock lockPool = new ReentrantLock();
  protected static ReentrantLock lockJedis = new ReentrantLock();

  private static Logger _LOGGER = LoggerFactory.getLogger(RedisUtil.class);

  private JedisPool jedisPool = null;

  /**
   * redis过期时间,以秒为单位
   */
  public final static int EXRP_HOUR = 60 * 60;            //一小时
  public final static int EXRP_DAY = 60 * 60 * 24;        //一天
  public final static int EXRP_MONTH = 60 * 60 * 24 * 30;    //一个月

  /**
   * 初始化Redis连接池
   */
  private void initialPool() {
    try {
      jedisPool = redisConfig.getJedisPool();
    } catch (Exception e) {
      _LOGGER.error("First create JedisPool error : " + e);
    }
  }

  /**
   * 在多线程环境同步初始化
   */
  private synchronized void poolInit() {
    if (null == jedisPool) {
      initialPool();
    }
  }


  /**
   * 同步获取Jedis实例
   *
   * @return Jedis
   */
  public synchronized Jedis getJedis() {
    poolInit();
    Jedis jedis = null;
    try {
      if (null != jedisPool) {
        jedis = jedisPool.getResource();
        try {
          jedis.auth(redisConfig.getPassword());
        } catch (Exception e) {

        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      _LOGGER.error("Get jedis error : " + e);
    }
    return jedis;
  }

  /**
   * 设置 String
   */
  public synchronized void set(String key, String value) {
    try {
      value = StringUtils.isBlank(value) ? "" : value;
      Jedis jedis = getJedis();
      jedis.set(key, value);
      jedis.close();
    } catch (Exception e) {
      _LOGGER.error("Set key error : " + e);
    }
  }

  /**
   * 设置 byte[]
   */
  public synchronized void set(byte[] key, byte[] value) {
    try {
      Jedis jedis = getJedis();
      jedis.set(key, value);
      jedis.close();
    } catch (Exception e) {
      _LOGGER.error("Set key error : " + e);
    }
  }

  /**
   * 设置 String 过期时间
   *
   * @param seconds 以秒为单位
   */
  public synchronized void set(String key, String value, int seconds) {
    try {
      value = StringUtils.isBlank(value) ? "" : value;
      Jedis jedis = getJedis();
      jedis.setex(key, seconds, value);
      jedis.close();
    } catch (Exception e) {
      _LOGGER.error("Set keyex error : " + e);
    }
  }

  /**
   * 设置 byte[] 过期时间
   *
   * @param seconds 以秒为单位
   */
  public synchronized void set(byte[] key, byte[] value, int seconds) {
    try {
      Jedis jedis = getJedis();
      jedis.set(key, value);
      jedis.expire(key, seconds);
      jedis.close();
    } catch (Exception e) {
      _LOGGER.error("Set key error : " + e);
    }
  }

  /**
   * 获取String值
   *
   * @return value
   */
  public synchronized String get(String key) {
    Jedis jedis = getJedis();
    if (null == jedis) {
      return null;
    }
    String value = jedis.get(key);
    jedis.close();
    return value;
  }

  /**
   * 获取byte[]值
   *
   * @return value
   */
  public synchronized byte[] get(byte[] key) {
    Jedis jedis = getJedis();
    if (null == jedis) {
      return null;
    }
    byte[] value = jedis.get(key);
    jedis.close();
    return value;
  }

  /**
   * 删除值
   */
  public synchronized void remove(String key) {
    try {
      Jedis jedis = getJedis();
      jedis.del(key);
      jedis.close();
    } catch (Exception e) {
      _LOGGER.error("Remove keyex error : " + e);
    }
  }

  /**
   * 删除值
   */
  public synchronized void remove(byte[] key) {
    try {
      Jedis jedis = getJedis();
      jedis.del(key);
      jedis.close();
    } catch (Exception e) {
      _LOGGER.error("Remove keyex error : " + e);
    }
  }

  /**
   * lpush
   */
  public synchronized void lpush(String key, String... strings) {
    try {
      Jedis jedis = getJedis();
      jedis.lpush(key, strings);
      jedis.close();
    } catch (Exception e) {
      _LOGGER.error("lpush error : " + e);
    }
  }

  /**
   * lrem
   */
  public synchronized void lrem(String key, long count, String value) {
    try {
      Jedis jedis = getJedis();
      jedis.lrem(key, count, value);
      jedis.close();
    } catch (Exception e) {
      _LOGGER.error("lpush error : " + e);
    }
  }

  /**
   * sadd
   */
  public synchronized void sadd(String key, String value, int seconds) {
    try {
      Jedis jedis = getJedis();
      jedis.sadd(key, value);
      jedis.expire(key, seconds);
      jedis.close();
    } catch (Exception e) {
      _LOGGER.error("sadd error : " + e);
    }
  }

  /**
   * incr
   *
   * @return value
   */
  public synchronized Long incr(String key) {
    Jedis jedis = getJedis();
    if (null == jedis) {
      return null;
    }
    long value = jedis.incr(key);
    jedis.close();
    return value;
  }

  /**
   * decr
   *
   * @return value
   */
  public synchronized Long decr(String key) {
    Jedis jedis = getJedis();
    if (null == jedis) {
      return null;
    }
    long value = jedis.decr(key);
    jedis.close();
    return value;
  }
}
