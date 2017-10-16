package com.xjp.service.impl;

import com.xjp.annotation.BaseService;
import com.xjp.common.service.BaseServiceImpl;
import com.xjp.dao.UserMapper;
import com.xjp.model.User;
import com.xjp.service.Userservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

/**
 * user service.
 *
 * @author xujiping 2017-09-19 17:30
 */

@Service
@Transactional
@BaseService
public class UserServiceImpl extends BaseServiceImpl<UserMapper, User, User> implements
    Userservice {

  private static Logger _log = LoggerFactory.getLogger(UserServiceImpl.class);

  @SuppressWarnings("SpringJavaAutowiringInspection")
  @Autowired
  UserMapper userMapper;

  @Override
  public int deleteByPrimaryKeys(String[] ids) throws SQLException {
    for (String id :
        ids) {
      int i = userMapper.deleteByPrimaryKey(Integer.parseInt(id));
      if (i == 0) {
        throw new SQLException("删除用户失败：id=" + id);
      }
    }
    return 1;
  }
}
