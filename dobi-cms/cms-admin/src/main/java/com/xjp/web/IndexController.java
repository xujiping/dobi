package com.xjp.web;

import com.xjp.model.OnlineSession;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * index.
 *
 * @author xujiping 2017-09-19 15:05
 */

@Controller
public class IndexController {

    @Autowired
    private SessionDAO sessionDAO;

    /**
     * index.
     *
     * @return index.html
     */
    @RequestMapping(value = {"", "/index"})
    public String index(Model model) {
        //获取session对象
        Session session = SecurityUtils.getSubject().getSession();
        //从自定操作类中读取的session才能转换成自定义session类型
        Session readSession = sessionDAO.readSession(session.getId());
        if (readSession != null && readSession instanceof OnlineSession){
            OnlineSession onlineSession = (OnlineSession) readSession;
            model.addAttribute("sessionId", onlineSession.getId());  //唯一标识
            model.addAttribute("sessionHost", onlineSession.getHost());  //主机地址
            model.addAttribute("sessionTimeout", onlineSession.getTimeout());  //过期时间（毫秒）
            model.addAttribute("sessionStartTime", onlineSession.getStartTimestamp());  //启动时间
            model.addAttribute("sessionLastAccessTime", onlineSession.getLastAccessTime());  //最后访问时间
            model.addAttribute("userAgent", onlineSession.getUserAgent());
            model.addAttribute("status", onlineSession.getStatus());
            model.addAttribute("systemHost", onlineSession.getSystemHost());
        }

        return "index";
    }
}
