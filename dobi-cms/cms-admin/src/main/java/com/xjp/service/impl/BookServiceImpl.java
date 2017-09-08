package com.xjp.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xjp.annotation.BaseService;
import com.xjp.dao.BookMapper;
import com.xjp.model.Book;
import com.xjp.model.BookExample;
import com.xjp.service.BookService;

/**
* @author xujiping
* @version 2017年9月6日 下午3:52:34
* 类说明
*/
@Service
@Transactional
@BaseService
public class BookServiceImpl extends BaseServiceImpl<BookMapper, Book, BookExample> implements BookService {
	
	  private static Logger _log = LoggerFactory.getLogger(BookServiceImpl.class);

	    @Autowired
	    public BookMapper bookMapper;

}
