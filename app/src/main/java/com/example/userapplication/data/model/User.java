package com.example.userapplication.data.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class User {

    private String name;
    private String email;

    @PrimaryKey
    private long mobile;
    private int age;

    public User() {
    }

    public User(String name, String email, long mobile, int age) {
        this.name = name;
        this.email = email;
        this.mobile = mobile;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getMobile() {
        return mobile;
    }

    public void setMobile(long mobile) {
        this.mobile = mobile;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
