package com.example.mvploginsystem.login;

public interface LoginView{
    void setNameError();

    void setPasswordError();

    void setOnSuccess(String username,String password);

}
