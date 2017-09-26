package com.xjp.common.result;

import com.xjp.common.base.BaseResult;
import com.xjp.common.constants.ResultConstants;

/**
 * 返回结果.
 *
 * @author xujiping 2017-09-21 10:10
 */

public class Result extends BaseResult {

  public Result(ResultConstants resultConstants, Object data) {
    super(resultConstants.getCode(), resultConstants.getMessage(), data);
  }

}
