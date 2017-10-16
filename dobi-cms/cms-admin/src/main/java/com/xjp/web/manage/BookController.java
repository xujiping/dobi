package com.xjp.web.manage;

import com.xjp.common.constants.ResultConstants;
import com.xjp.common.result.Result;
import com.xjp.dao.BookMapper;
import com.xjp.model.Book;
import com.xjp.service.BookService;

import org.apache.ibatis.session.RowBounds;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * book.
 *
 * @author xujiping 2017-09-20 15:49
 */
@Controller
@RequestMapping("/manage/book")
public class BookController {

  private static Logger _log = LoggerFactory.getLogger(BookController.class);

  @SuppressWarnings("SpringJavaAutowiringInspection")
  @Autowired
  private BookMapper bookMapper;

  @Autowired
  private BookService bookService;

  @RequestMapping(value = "index")
  public String index() {
    return "manage/book/index";
  }

  /**
   * 查询书籍列表.
   *
   * @param offset 第几页
   * @param limit  每页多少行
   * @param sort   排序（未实现）
   * @param order  排序列
   * @return Map
   */
  @RequiresPermissions("cms:book:view")
  @RequestMapping(value = "list")
  @ResponseBody
  public Object list(
      @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
      @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
      @RequestParam(required = false, value = "sort") String sort,
      @RequestParam(required = false, value = "order") String order) {
    // TODO 排序未实现
    Book book = new Book();
    RowBounds rowBounds = new RowBounds(offset, limit);
    List<Book> rows = bookMapper.selectByRowBounds(book, rowBounds);
    long total = bookMapper.selectCount(book);
    Map<String, Object> result = new HashMap<>();
    result.put("rows", rows);
    result.put("total", total);
    return result;
  }

  @RequiresPermissions("cms:book:create")
  @RequestMapping(value = "add")
  public String add() {
    return "manage/book/add";
  }

  /**
   * 增加书籍.
   *
   * @param book book
   * @return json
   */
  @RequiresPermissions(value = "cms:book:create")
  @RequestMapping(value = "add", method = RequestMethod.POST)
  @ResponseBody
  public Object doAdd(Book book) {
    long time = System.currentTimeMillis();
    int count = bookMapper.insertSelective(book);
    return new Result(ResultConstants.SUCCESS, count);
  }

  /**
   * 删除书籍.
   *
   * @param ids 多个id以-分隔
   * @return json
   */
  @RequiresPermissions("cms:book:delete")
  @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
  @ResponseBody
  public Object delete(@PathVariable("ids") String ids) {
    int count = 0;
    try {
      count = bookService.deleteByPrimaryKeys(ids.split("-"));
    } catch (SQLException e) {
      return new Result(ResultConstants.FAILED, count);
    }
    return new Result(ResultConstants.SUCCESS, count);
  }

  /**
   * 修改页面.
   *
   * @param id    book_id
   * @param model model
   * @return html
   */
  @RequiresPermissions("cms:book:update")
  @RequestMapping(value = "update/{id}")
  public String update(@PathVariable("id") String id, Model model) {
    Book book = bookMapper.selectByPrimaryKey(Integer.parseInt(id));
    model.addAttribute("book", book);
    return "manage/book/update";
  }

  /**
   * 修改书籍信息.
   *
   * @param book book
   * @return json
   */
  @RequiresPermissions("cms:book:update")
  @RequestMapping(value = "update", method = RequestMethod.POST)
  @ResponseBody
  public Object doUpdate(Book book) {
    int count = bookMapper.updateByPrimaryKeySelective(book);
    if (count != 1) {
      return new Result(ResultConstants.FAILED, count);
    }
    return new Result(ResultConstants.SUCCESS, count);
  }

  /**
   * 权限页面.
   *
   * @param id    bookId
   * @param model model
   * @return html
   */
  @RequiresPermissions("cms:permission:view")
  @RequestMapping(value = "permission/{id}")
  public String permission(@PathVariable("id") String id, Model model) {
    Book book = bookMapper.selectByPrimaryKey(Integer.parseInt(id));
    model.addAttribute("book", book);
    return "manage/book/permission";
  }

}
