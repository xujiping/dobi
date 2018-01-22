package com.study.session;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 全局Session操作类
 *
 * @author xujiping 2018-01-05 16:09
 */

public class GlobalSessions {

    private static Map<String, HttpSession> sessions = new HashMap<>();

    public static void addSession(String sessionId, HttpSession session){
        sessions.put(sessionId, session);
    }

    public static void delSession(String sessionId){
        sessions.remove(sessionId);
    }

    public static HttpSession getSession(String sessionId){
        return sessions.get(sessionId);
    }
}
