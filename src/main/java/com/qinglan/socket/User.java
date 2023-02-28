package com.qinglan.socket;

import java.io.Serializable;

public enum User implements Serializable {
    xiongbl("xiongbl","123456");

    private final String name;

    private final String password;

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
