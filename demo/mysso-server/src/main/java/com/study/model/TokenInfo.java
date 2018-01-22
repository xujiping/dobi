package com.study.model;

/**
 * token信息
 *
 * @author xujiping 2018-01-05 14:56
 */

public class TokenInfo {

    private int userId;

    private String username;

    private String password;

    private String globalId;

    public TokenInfo(int userId, String username, String password, String globalId) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.globalId = globalId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGlobalId() {
        return globalId;
    }

    public void setGlobalId(String globalId) {
        this.globalId = globalId;
    }
}
