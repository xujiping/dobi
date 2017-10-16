package com.xjp.service.impl;

import com.xjp.annotation.BaseService;
import com.xjp.common.service.BaseServiceImpl;
import com.xjp.dao.BookFormatMapper;
import com.xjp.model.Book;
import com.xjp.model.BookExample;
import com.xjp.model.BookFormat;
import com.xjp.service.BookFormatService;
import com.xjp.service.BookService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

import javax.annotation.Resource;

/**
 * book service.
 *
 * @author xujiping 2017-09-19 17:30
 */
@Service
@Transactional
@BaseService
public class BookFormatServiceImpl extends BaseServiceImpl<BookFormatMapper, BookFormat, BookFormat> implements
    BookFormatService {

  private static Logger _log = LoggerFactory.getLogger(BookFormatServiceImpl.class);

  BookFormatMapper bookFormatMapper;

  @SuppressWarnings("SpringJavaAutowiringInspection")
  @Resource
  public void setBookFormatMapper(BookFormatMapper bookFormatMapper) {
    this.bookFormatMapper = bookFormatMapper;
  }

  @Override
  public int deleteByPrimaryKeys(String[] ids) throws SQLException {
    for (String id :
        ids) {
      int i = bookFormatMapper.deleteByPrimaryKey(Integer.parseInt(id));
      if (i == 0) {
        throw new SQLException("删除书籍格式失败：id=" + id);
      }
    }
    return 1;
  }
}
