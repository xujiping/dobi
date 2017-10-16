package com.xjp.common.constants;

/**
 * 接口常量枚举类.
 *
 * @author xujiping 2017-09-21 10:05
 */
public enum ResultConstants {

  FAILED(0, "failed"),
  SUCCESS(1, "success"),

  FILE_TYPE_ERROR(20001, "File type not supported!"),
  INVALID_LENGTH(20002, "Invalid length"),
  INVALID_PARAMETER(20003, "Invalid parameter"),
  no_permission(20004, "No permission");

  public int code;

  public String message;

  ResultConstants(int code, String message) {
    this.code = code;
    this.message = message;
  }

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
