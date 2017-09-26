package com.xjp.web.manage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xjp.common.constants.ResultConstants;
import com.xjp.common.result.Result;
import com.xjp.dao.RoleMapper;
import com.xjp.dao.RolePermissionMapper;
import com.xjp.model.Role;
import com.xjp.model.RolePermission;
import com.xjp.service.RoleService;

import org.apache.ibatis.session.RowBounds;
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

import javax.servlet.http.HttpServletRequest;

/**
 * role.
 *
 * @author xujiping 2017-09-20 15:49
 */
@Controller
@RequestMapping("/manage/role")
public class RoleController {

  private static Logger _log = LoggerFactory.getLogger(RoleController.class);

  @SuppressWarnings("SpringJavaAutowiringInspection")
  @Autowired
  private RoleMapper roleMapper;

  @Autowired
  private RoleService roleService;

  @SuppressWarnings("SpringJavaAutowiringInspection")
  @Autowired
  private RolePermissionMapper rolePermissionMapper;

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

  /**
   * 增加角色.
   *
   * @param role role
   * @return json
   */
  @RequestMapping(value = "add", method = RequestMethod.POST)
  @ResponseBody
  public Object doAdd(Role role) {
    long time = System.currentTimeMillis();
    role.setCtime(time);
    int count = roleMapper.insertSelective(role);
    return new Result(ResultConstants.SUCCESS, count);
  }

  /**
   * 删除角色.
   *
   * @param ids 多个id以-分隔
   * @return json
   */
  @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
  @ResponseBody
  public Object delete(@PathVariable("ids") String ids) {
    int count = 0;
    try {
      count = roleService.deleteByPrimaryKeys(ids.split("-"));
    } catch (SQLException e) {
      return new Result(ResultConstants.FAILED, count);
    }
    return new Result(ResultConstants.SUCCESS, count);
  }

  /**
   * 修改页面.
   *
   * @param id    role_id
   * @param model model
   * @return html
   */
  @RequestMapping(value = "update/{id}")
  public String update(@PathVariable("id") String id, Model model) {
    Role role = roleMapper.selectByPrimaryKey(Integer.parseInt(id));
    model.addAttribute("role", role);
    return "manage/role/update";
  }

  /**
   * 修改角色信息.
   *
   * @param role role
   * @return json
   */
  @RequestMapping(value = "update", method = RequestMethod.POST)
  @ResponseBody
  public Object doUpdate(Role role) {
    int count = roleMapper.updateByPrimaryKeySelective(role);
    if (count != 1) {
      return new Result(ResultConstants.FAILED, count);
    }
    return new Result(ResultConstants.SUCCESS, count);
  }

  @RequestMapping(value = "permission/{id}")
  public String permission(@PathVariable("id") String id, Model model) {
    Role role = roleMapper.selectByPrimaryKey(Integer.parseInt(id));
    model.addAttribute("role", role);
    return "manage/role/permission";
  }

  @RequestMapping(value = "permission/{id}", method = RequestMethod.POST)
  @ResponseBody
  public Object doPermission(@PathVariable("id") String id, HttpServletRequest request) {
    boolean checked = false;
    String datas = request.getParameter("datas");
    _log.error("修改用户" + id + "权限：" + datas);
    RolePermission rolePermission = new RolePermission();
    rolePermission.setRoleId(Integer.parseInt(id));
    JSONArray dataArray = JSONArray.parseArray(datas);
    for (Object object :
        dataArray) {
      JSONObject jsonObject = (JSONObject) object;
      checked = jsonObject.getBoolean("checked");
      rolePermission.setPermissionId(jsonObject.getInteger("permission_id"));
      if (checked) {
        //新增权限
        int insertCode = rolePermissionMapper.insertSelective(rolePermission);
        if (insertCode != 1) {
          _log.error("新增权限失败：" + rolePermission.toString());
          return new Result(ResultConstants.FAILED, "修改权限失败");
        }
      } else {
        //删除权限
        int deleteCode = rolePermissionMapper.delete(rolePermission);
        if (deleteCode != 1) {
          _log.error("删除权限失败：" + rolePermission.toString());

          return new Result(ResultConstants.FAILED, "修改权限失败");
        }
      }
      return new Result(ResultConstants.SUCCESS, "修改权限成功");
    }
    return new Result(ResultConstants.SUCCESS, "修改权限成功");
  }

}
