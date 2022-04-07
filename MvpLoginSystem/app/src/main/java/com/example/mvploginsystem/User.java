package com.example.mvploginsystem;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.NotNull;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class User {
    @Id(autoincrement = true)
    private Long number;
    @NotNull
    private String username;
    @NotNull
    private String password;
    @Generated(hash = 1149057008)
    public User(Long number, @NotNull String username, @NotNull String password) {
        this.number = number;
        this.username = username;
        this.password = password;
    }
    @Generated(hash = 586692638)
    public User() {
    }
    public Long getNumber() {
        return this.number;
    }
    public void setNumber(Long number) {
        this.number = number;
    }
    public String getUsername() {
        return this.username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return this.password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
   
}
