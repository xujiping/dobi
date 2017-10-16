package com.xjp.web.manage;

import com.xjp.common.constants.ResultConstants;
import com.xjp.common.result.Result;
import com.xjp.dao.BookFormatMapper;
import com.xjp.model.BookFormat;
import com.xjp.service.BookFormatService;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

/**
 * bookFormat.
 *
 * @author xujiping 2017-09-20 15:49
 */
@Controller
@RequestMapping("/manage/bookFormat")
public class BookFormatController {

  private static Logger _log = LoggerFactory.getLogger(BookFormatController.class);

  @SuppressWarnings("SpringJavaAutowiringInspection")
  @Autowired
  private BookFormatMapper bookFormatMapper;

  @Autowired
  private BookFormatService bookFormatService;


  @RequestMapping(value = "index")
  public String index() {
    return "manage/bookFormat/index";
  }

  /**
   * 查询书籍格式列表.
   *
   * @param offset 第几页
   * @param limit  每页多少行
   * @param sort   排序（未实现）
   * @param order  排序列
   * @return Map
   */
  @RequiresPermissions("cms:format:view")
  @RequestMapping(value = "list")
  @ResponseBody
  public Object list(
      @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
      @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
      @RequestParam(required = false, value = "sort") String sort,
      @RequestParam(required = false, value = "order") String order) {
    // TODO 排序未实现
    BookFormat bookFormat = new BookFormat();
    RowBounds rowBounds = new RowBounds(offset, limit);
    List<BookFormat> rows = bookFormatMapper.selectByRowBounds(bookFormat, rowBounds);
    long total = bookFormatMapper.selectCount(bookFormat);
    Map<String, Object> result = new HashMap<>();
    result.put("rows", rows);
    result.put("total", total);
    return result;
  }

  @RequiresPermissions("cms:format:create")
  @RequestMapping(value = "add")
  public String add() {
    return "manage/bookFormat/add";
  }

  /**
   * 增加书籍格式.
   *
   * @param bookFormat bookFormat
   * @return json
   */
  @RequiresPermissions("cms:format:create")
  @RequestMapping(value = "add", method = RequestMethod.POST)
  @ResponseBody
  public Object doAdd(BookFormat bookFormat) {
    long time = System.currentTimeMillis();
    int count = bookFormatMapper.insertSelective(bookFormat);
    return new Result(ResultConstants.SUCCESS, count);
  }

  /**
   * 删除书籍格式.
   *
   * @param ids 多个id以-分隔
   * @return json
   */
  @RequiresPermissions("cms:format:delete")
  @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
  @ResponseBody
  public Object delete(@PathVariable("ids") String ids) {
    int count = 0;
    try {
      count = bookFormatService.deleteByPrimaryKeys(ids.split("-"));
    } catch (SQLException e) {
      return new Result(ResultConstants.FAILED, count);
    }
    return new Result(ResultConstants.SUCCESS, count);
  }

  /**
   * 修改页面.
   *
   * @param id    bookFormat_id
   * @param model model
   * @return html
   */
  @RequiresPermissions("cms:format:update")
  @RequestMapping(value = "update/{id}")
  public String update(@PathVariable("id") String id, Model model) {
    BookFormat bookFormat = bookFormatMapper.selectByPrimaryKey(Integer.parseInt(id));
    model.addAttribute("bookFormat", bookFormat);
    return "manage/bookFormat/update";
  }

  /**
   * 修改书籍格式信息.
   *
   * @param bookFormat bookFormat
   * @return json
   */
  @RequiresPermissions("cms:format:update")
  @RequestMapping(value = "update", method = RequestMethod.POST)
  @ResponseBody
  public Object doUpdate(BookFormat bookFormat) {
    int count = bookFormatMapper.updateByPrimaryKeySelective(bookFormat);
    if (count != 1) {
      return new Result(ResultConstants.FAILED, count);
    }
    return new Result(ResultConstants.SUCCESS, count);
  }

  /**
   * 权限页面.
   *
   * @param id    bookFormatId
   * @param model model
   * @return html
   */
  @RequiresPermissions("cms:permission:view")
  @RequestMapping(value = "permission/{id}")
  public String permission(@PathVariable("id") String id, Model model) {
    BookFormat bookFormat = bookFormatMapper.selectByPrimaryKey(Integer.parseInt(id));
    model.addAttribute("bookFormat", bookFormat);
    return "manage/bookFormat/permission";
  }

}
