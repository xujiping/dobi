package com.xjp.service.impl;

import com.xjp.dao.BookMapper;
import com.xjp.model.Book;
import com.xjp.model.BookExample;
import com.xjp.service.BookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * book service.
 *
 * @author xujiping 2017-09-19 17:30
 */

public class BookServiceImpl extends BaseServiceImpl<BookMapper, Book, BookExample> implements
    BookService {

  private static Logger _log = LoggerFactory.getLogger(BookServiceImpl.class);

  @Autowired
  BookMapper bookMapper;
}
