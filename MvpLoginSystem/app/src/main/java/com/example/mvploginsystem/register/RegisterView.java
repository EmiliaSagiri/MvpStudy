package com.example.mvploginsystem.register;

public interface RegisterView {
    void set_NameError();

    void set_PasswordError();

    void set_OnSuccess(String username,String password);
}
