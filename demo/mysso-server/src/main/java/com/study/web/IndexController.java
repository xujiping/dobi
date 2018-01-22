package com.study.web;

import com.study.model.TokenInfo;
import com.study.model.User;
import com.study.util.TokenUtil;
import org.junit.runners.Parameterized;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.swing.StringUIClientPropertyKey;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.UUID;

/**
 * ${DESCRIPTION}
 *
 * @author xujiping 2018-01-05 15:05
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/page/login")
    public String login(HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        //获取回调地址
        String returnUrl = request.getParameter("returnUrl");
        if (returnUrl == null) {
            //代表浏览器直接访问该接口
            if (user != null) {
                return "success";
            }
            return "login";
        }
        //通过应用之间跳转
        if (user != null) {
            //生成token
            int userId = user.getId();
            String username = user.getUsername();
            String password = user.getPassword();
            TokenInfo tokenInfo = new TokenInfo(userId, username, password, session.getId());
            String tokenId = UUID.randomUUID().toString();
            TokenUtil.setToken(tokenId, tokenInfo);
            if (!returnUrl.contains("?")) {
                returnUrl += "?";
            }
            return "redirect:http://" + returnUrl + "token=" + tokenId;
        }
        return "login";
    }

    @PostMapping("/auth/login")
    public String auth(HttpServletRequest request, String username, String password, String returnUrl) {
        HttpSession session = request.getSession();
        if (username.equals("xjp") && password.equals("111")) {
            //登录成功
            if (StringUtils.isEmpty(returnUrl)) {
                //直接从认证中心登录
                return "success";
            }
            //生成token
            TokenInfo tokenInfo = new TokenInfo(1, username, password, session.getId());
            String tokenId = UUID.randomUUID().toString();
            TokenUtil.setToken(tokenId, tokenInfo);
            if (!returnUrl.contains("?")) {
                returnUrl += "?";
            }
            return "redirect:http://" + returnUrl + "token=" + tokenId;
        }
        return "login";
    }
}
