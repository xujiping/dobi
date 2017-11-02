package com.xjp.bookhouse.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * book.
 *
 * @author xujiping 2017-10-27 17:07
 */
@FeignClient(value = "cmsBook")
public interface BookService {

  @GetMapping("/info")
  String bookInfo();

}
