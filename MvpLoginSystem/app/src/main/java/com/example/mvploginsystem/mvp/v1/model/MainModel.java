package com.example.mvploginsystem.mvp.v1.model;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;

import com.example.mvploginsystem.DBManager;
import com.example.mvploginsystem.MainActivity;
import com.example.mvploginsystem.User;
import com.example.mvploginsystem.mvp.v1.MainContract;

import java.util.ArrayList;
import java.util.List;

public class MainModel implements MainContract.IMainModel{
    @Override
    public void login(String username, String password, LoginCallback loginCallback) {
        new Handler().postDelayed(() ->{
                if(loginCallback==null){
                    throw new RuntimeException("loginDataCallback can not be null!!!");
                }
                loginCallback.getNameError(TextUtils.isEmpty(username));
                loginCallback.getPasswordError(TextUtils.isEmpty(password));
                if(!TextUtils.isEmpty(username)&&!TextUtils.isEmpty(password)){
                    loginCallback.getOnSuccess(true);
                }
                else {
                    loginCallback.getOnSuccess(false);
                }
            },2000);
    }

}
