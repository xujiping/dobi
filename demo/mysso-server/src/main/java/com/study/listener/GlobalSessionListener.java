package com.study.listener;

import com.study.session.GlobalSessions;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * 全局会话监听类
 *
 * @author xujiping 2018-01-05 16:13
 */
@Component
public class GlobalSessionListener implements HttpSessionListener {
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        GlobalSessions.addSession(httpSessionEvent.getSession().getId(), httpSessionEvent.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        GlobalSessions.delSession(httpSessionEvent.getSession().getId());
    }
}
