package com.peixiao.spring5.entity;

/**
 * @author Peixiao Zhao
 * @date 2020/9/16 17:14
 */
public class Book {
    private int userId;
    private String username;
    private String ustatus;

    public Book() {
    }

    public Book(int userId, String username, String ustatus) {
        this.userId = userId;
        this.username = username;
        this.ustatus = ustatus;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUstatus(String ustatus) {
        this.ustatus = ustatus;
    }

    public int getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public String getUstatus() {
        return ustatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "userId=" + userId +
                ", username='" + username + '\'' +
                ", ustatus='" + ustatus + '\'' +
                '}';
    }
}


