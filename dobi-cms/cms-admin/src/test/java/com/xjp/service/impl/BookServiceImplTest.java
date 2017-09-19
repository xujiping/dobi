package com.xjp.service.impl;

import com.xjp.dao.BookMapper;
import com.xjp.model.Book;
import com.xjp.model.User;
import com.xjp.service.BookService;
import com.xjp.service.Userservice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * test.
 * 
 * @author xujiping
 * @version 2017年9月6日 下午3:55:55 类说明
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class BookServiceImplTest {

//  @Autowired
//  private BookService bookService;
//
//  @Autowired
//  private BookMapper bookMapper;

  @Autowired
  private Userservice userservice;

  @Test
  public void testSelect() {
    userservice.initMapper();
    List<User> book = userservice.selectAll();
    System.out.println("书籍：" + book);
  }

}
