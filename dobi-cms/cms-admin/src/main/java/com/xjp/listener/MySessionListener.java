package com.xjp.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;
import org.springframework.stereotype.Component;

/**
 * 自定义会话监听器
 *
 * @author xujiping 2017-12-22 15:40
 */
@Component
public class MySessionListener implements SessionListener {
    @Override
    public void onStart(Session session) {
        System.out.println("会话创建：" + session.getId());
    }

    @Override
    public void onStop(Session session) {
        System.out.println("会话停止：" + session.getId());
    }

    @Override
    public void onExpiration(Session session) {
        System.out.println("会话过期：" + session.getId());
    }
}
