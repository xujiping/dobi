package com.study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * ${DESCRIPTION}
 *
 * @author xujiping 2018-01-05 15:02
 */
@SpringBootApplication
@EnableCaching
public class MyssoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyssoServerApplication.class, args);
    }
}
