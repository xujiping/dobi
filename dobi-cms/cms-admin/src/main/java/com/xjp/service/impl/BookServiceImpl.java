package com.xjp.service.impl;

import com.xjp.annotation.BaseService;
import com.xjp.common.service.BaseServiceImpl;
import com.xjp.dao.BookMapper;
import com.xjp.model.Book;
import com.xjp.model.BookExample;
import com.xjp.service.BookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * book service.
 *
 * @author xujiping 2017-09-19 17:30
 */
@Service
@Transactional
@BaseService
public class BookServiceImpl extends BaseServiceImpl<BookMapper, Book, BookExample> implements
    BookService {

  private static Logger _log = LoggerFactory.getLogger(BookServiceImpl.class);

  BookMapper bookMapper;

  @SuppressWarnings("SpringJavaAutowiringInspection")
  @Resource
  public void setBookMapper(BookMapper bookMapper) {
    this.bookMapper = bookMapper;
  }
}
