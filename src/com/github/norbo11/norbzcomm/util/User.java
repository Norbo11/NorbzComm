package com.github.norbo11.norbzcomm.util;

import java.io.Serializable;

public class User implements Serializable {
    public User(String username) {
        this.username = username;
    }

    private static final long serialVersionUID = 1L;

    private String username;

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return username;
    }

}
