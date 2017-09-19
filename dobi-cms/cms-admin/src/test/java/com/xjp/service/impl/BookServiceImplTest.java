package com.xjp.service.impl;

import com.xjp.dao.BookMapper;
import com.xjp.model.Book;
import com.xjp.service.BookService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * test.
 * 
 * @author xujiping
 * @version 2017年9月6日 下午3:55:55 类说明
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookServiceImplTest {

  @Autowired
  private BookService bookService;

  @Autowired
  private BookMapper bookMapper;

  @Test
  public void testSelect() {
    bookService.initMapper();
    Book book1 = new Book();
    int book = bookService.selectCount(book1);
    System.out.println("书籍：" + book);
  }

}
