package com.xjp.web.manage;

import com.xjp.dao.RoleMapper;
import com.xjp.model.Role;

import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * role.
 *
 * @author xujiping 2017-09-20 15:49
 */
@Controller
@RequestMapping("/manage/role")
public class RoleController {

  @SuppressWarnings("SpringJavaAutowiringInspection")
  @Autowired
  private RoleMapper roleMapper;

  @RequestMapping(value = "index")
  public String index() {
    return "manage/role/index";
  }

  /**
   * 查询角色列表
   *
   * @param offset 第几页
   * @param limit  每页多少行
   * @param sort   排序（未实现）
   * @param order  排序列
   * @return Map<String, Object>
   */
  @RequestMapping(value = "list")
  @ResponseBody
  public Object list(
      @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
      @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
      @RequestParam(required = false, value = "sort") String sort,
      @RequestParam(required = false, value = "order") String order) {
    Role role = new Role();
    RowBounds rowBounds = new RowBounds(offset, limit);
    List<Role> rows = roleMapper.selectByRowBounds(role, rowBounds);
    long total = roleMapper.selectCount(role);
    Map<String, Object> result = new HashMap<>();
    result.put("rows", rows);
    result.put("total", total);
    return result;
  }

  @RequestMapping(value = "add")
  public String add() {
    return "manage/role/add";
  }

}
