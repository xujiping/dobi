package com.xjp.model;

import org.apache.shiro.session.mgt.SimpleSession;
import org.springframework.stereotype.Component;

/**
 * 在线状态session
 *
 * @author xujiping 2017-12-22 17:39
 */

public class OnlineSession extends SimpleSession {

    public static enum OnlineStatus {
        on_line("在线"), hidden("隐身"), force_logout("强制退出");

        private final String info;

        private OnlineStatus(String info) {
            this.info = info;
        }
    }

    private String userAgent; //用户浏览器类型
    private OnlineStatus status = OnlineStatus.on_line;  //在线状态
    private String systemHost;  //用户登录时系统IP

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public OnlineStatus getStatus() {
        return status;
    }

    public void setStatus(OnlineStatus status) {
        this.status = status;
    }

    public String getSystemHost() {
        return systemHost;
    }

    public void setSystemHost(String systemHost) {
        this.systemHost = systemHost;
    }
}
