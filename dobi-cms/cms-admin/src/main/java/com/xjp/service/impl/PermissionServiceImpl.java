package com.xjp.service.impl;

import com.xjp.annotation.BaseService;
import com.xjp.common.service.BaseServiceImpl;
import com.xjp.dao.BookMapper;
import com.xjp.dao.PermissionMapper;
import com.xjp.model.Book;
import com.xjp.model.BookExample;
import com.xjp.model.Permission;
import com.xjp.service.BookService;
import com.xjp.service.PermissionService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * permission service.
 *
 * @author xujiping 2017-09-19 17:30
 */
@Service
@Transactional
@BaseService
public class PermissionServiceImpl extends BaseServiceImpl<PermissionMapper, Permission,
    Permission> implements
    PermissionService {

  private static Logger _log = LoggerFactory.getLogger(PermissionServiceImpl.class);

  @SuppressWarnings("SpringJavaAutowiringInspection")
  @Autowired
  PermissionMapper permissionMapper;

}
