package com.example.authorization.model;

import com.example.authorization.Authorities;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class User {
    private String name;
    private String password;
    private List<Authorities> authoritiesList = new ArrayList<>();

    public User() {
    }

    public User(String name, String password) {
        this.name = name;
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }



//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof User user)) return false;
//        return Objects.equals(getName(), user.getName()) && Objects.equals(getPassword(), user.getPassword());
//    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPassword());
    }
}
