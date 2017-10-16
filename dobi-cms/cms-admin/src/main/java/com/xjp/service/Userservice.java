package com.xjp.service;

import com.xjp.common.service.BaseService;
import com.xjp.model.User;

import java.sql.SQLException;


/**
 * user service.
 *
 * @author xujiping 2017-09-19 15:25
 */
public interface Userservice extends BaseService<User, User> {

  public int deleteByPrimaryKeys(String[] ids) throws SQLException;

}
