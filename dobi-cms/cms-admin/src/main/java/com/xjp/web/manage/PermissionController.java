package com.xjp.web.manage;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.xjp.dao.PermissionMapper;
import com.xjp.model.Permission;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * permission.
 *
 * @author xujiping 2017-09-20 15:49
 */
@Controller
@RequestMapping("/manage/permission")
public class PermissionController {

  @SuppressWarnings("SpringJavaAutowiringInspection")
  @Autowired
  private PermissionMapper permissionMapper;


  /**
   * 角色权限.
   * @param id role_id
   * @param model model
   * @return json
   */
  @RequestMapping(value = "role/{id}")
  @ResponseBody
  public Object rolePermission(@PathVariable("id") String id, Model model) {
    // TODO 角色权限
    List<Map<String, Object>> permissions = permissionMapper.selectByRoleId(Integer.parseInt(id));
    JSONArray array = new JSONArray();
    for (Map<String, Object> map :
        permissions) {
      JSONObject json = (JSONObject) JSON.toJSON(map);
      array.add(json);
    }
    return array;
  }
}
