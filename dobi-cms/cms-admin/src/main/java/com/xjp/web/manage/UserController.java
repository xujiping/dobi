package com.xjp.web.manage;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xjp.common.constants.ResultConstants;
import com.xjp.common.result.Result;
import com.xjp.dao.UserMapper;
import com.xjp.dao.UserPermissionMapper;
import com.xjp.model.User;
import com.xjp.model.UserPermission;
import com.xjp.service.Userservice;

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

import javax.servlet.http.HttpServletRequest;

/**
 * user.
 *
 * @author xujiping 2017-09-20 15:49
 */
@Controller
@RequestMapping("/manage/user")
public class UserController {

  private static Logger _log = LoggerFactory.getLogger(UserController.class);

  @SuppressWarnings("SpringJavaAutowiringInspection")
  @Autowired
  private UserMapper userMapper;

  @Autowired
  private Userservice userService;

  @SuppressWarnings("SpringJavaAutowiringInspection")
  @Autowired
  private UserPermissionMapper userPermissionMapper;

  @RequestMapping(value = "index")
  public String index() {
    return "manage/user/index";
  }

  /**
   * 查询用户列表.
   *
   * @param offset 第几页
   * @param limit  每页多少行
   * @param sort   排序（未实现）
   * @param order  排序列
   * @return Map
   */
  @RequestMapping(value = "list")
  @ResponseBody
  public Object list(
      @RequestParam(required = false, defaultValue = "0", value = "offset") int offset,
      @RequestParam(required = false, defaultValue = "10", value = "limit") int limit,
      @RequestParam(required = false, value = "sort") String sort,
      @RequestParam(required = false, value = "order") String order) {
    // TODO 排序未实现
    User user = new User();
    RowBounds rowBounds = new RowBounds(offset, limit);
    List<User> rows = userMapper.selectByRowBounds(user, rowBounds);
    long total = userMapper.selectCount(user);
    Map<String, Object> result = new HashMap<>();
    result.put("rows", rows);
    result.put("total", total);
    return result;
  }

  @RequestMapping(value = "add")
  public String add() {
    return "manage/user/add";
  }

  /**
   * 增加用户.
   *
   * @param user user
   * @return json
   */
  @RequiresPermissions(value = "cms:user:create")
  @RequestMapping(value = "add", method = RequestMethod.POST)
  @ResponseBody
  public Object doAdd(User user) {
    long time = System.currentTimeMillis();
    user.setCtime(time);
    int count = userMapper.insertSelective(user);
    return new Result(ResultConstants.SUCCESS, count);
  }

  /**
   * 删除用户.
   *
   * @param ids 多个id以-分隔
   * @return json
   */
  @RequestMapping(value = "/delete/{ids}", method = RequestMethod.GET)
  @ResponseBody
  public Object delete(@PathVariable("ids") String ids) {
    int count = 0;
    try {
      count = userService.deleteByPrimaryKeys(ids.split("-"));
    } catch (SQLException e) {
      return new Result(ResultConstants.FAILED, count);
    }
    return new Result(ResultConstants.SUCCESS, count);
  }

  /**
   * 修改页面.
   *
   * @param id    user_id
   * @param model model
   * @return html
   */
  @RequestMapping(value = "update/{id}")
  public String update(@PathVariable("id") String id, Model model) {
    User user = userMapper.selectByPrimaryKey(Integer.parseInt(id));
    model.addAttribute("user", user);
    return "manage/user/update";
  }

  /**
   * 修改用户信息.
   *
   * @param user user
   * @return json
   */
  @RequestMapping(value = "update", method = RequestMethod.POST)
  @ResponseBody
  public Object doUpdate(User user) {
    int count = userMapper.updateByPrimaryKeySelective(user);
    if (count != 1) {
      return new Result(ResultConstants.FAILED, count);
    }
    return new Result(ResultConstants.SUCCESS, count);
  }

  /**
   * 权限页面.
   *
   * @param id    userId
   * @param model model
   * @return html
   */
  @RequestMapping(value = "permission/{id}")
  public String permission(@PathVariable("id") String id, Model model) {
    User user = userMapper.selectByPrimaryKey(Integer.parseInt(id));
    model.addAttribute("user", user);
    return "manage/user/permission";
  }

  /**
   * 权限修改.
   *
   * @param id      userId
   * @param request request
   * @return json
   */
  @RequestMapping(value = "permission/{id}", method = RequestMethod.POST)
  @ResponseBody
  public Object doPermission(@PathVariable("id") String id, HttpServletRequest request) {
    boolean checked = false;
    String datas = request.getParameter("datas");
    _log.error("修改用户" + id + "权限：" + datas);
    UserPermission userPermission = new UserPermission();
    userPermission.setUserId(Integer.parseInt(id));
    JSONArray dataArray = JSONArray.parseArray(datas);
    for (Object object :
        dataArray) {
      JSONObject jsonObject = (JSONObject) object;
      checked = jsonObject.getBoolean("checked");
      userPermission.setPermissionId(jsonObject.getInteger("permission_id"));
      if (checked) {
        //新增权限
        int insertCode = userPermissionMapper.insertSelective(userPermission);
        if (insertCode != 1) {
          _log.error("新增权限失败：" + userPermission.toString());
          return new Result(ResultConstants.FAILED, "修改权限失败");
        }
      } else {
        //删除权限
        int deleteCode = userPermissionMapper.delete(userPermission);
        if (deleteCode != 1) {
          _log.error("删除权限失败：" + userPermission.toString());

          return new Result(ResultConstants.FAILED, "修改权限失败");
        }
      }
      return new Result(ResultConstants.SUCCESS, "修改权限成功");
    }
    return new Result(ResultConstants.SUCCESS, "修改权限成功");
  }

}
