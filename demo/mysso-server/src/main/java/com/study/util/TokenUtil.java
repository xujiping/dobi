package com.study.util;

import com.study.model.TokenInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * ${DESCRIPTION}
 *
 * @author xujiping 2018-01-05 15:50
 */
public class TokenUtil {

    @Autowired
    private static RedisTemplate redisTemplate;

    public static void setToken(String tokenId, TokenInfo tokenInfo){
        redisTemplate.opsForValue().set(tokenId, tokenInfo, 60000);
    }

    public static TokenInfo getToken(String tokenId){
        return (TokenInfo) redisTemplate.opsForValue().get(tokenId);
    }

}
