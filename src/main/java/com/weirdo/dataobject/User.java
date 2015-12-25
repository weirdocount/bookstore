package com.weirdo.dataobject;

/**
 * Created by daiqiang on 2015/12/25.
 */
public class User {

    private Integer id;
    private String username;
    private Integer accountId;

    public User() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", accountId=" + accountId +
                '}';
    }
}
