package com.xjp.web;

import com.xjp.common.constants.Constants;
import com.xjp.common.constants.ResultConstants;
import com.xjp.common.result.Result;

import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一异常处理
 *
 * @author xujiping 2017-10-16 11:15
 */

public abstract class ExceptionController {

  @ExceptionHandler({UnauthorizedException.class})
  @ResponseBody
  public Object exceptionProcess(){
    return new Result(ResultConstants.no_permission, "无权限访问");
  }
}
