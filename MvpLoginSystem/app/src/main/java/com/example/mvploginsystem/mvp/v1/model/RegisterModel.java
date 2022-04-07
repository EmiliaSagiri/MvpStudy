package com.example.mvploginsystem.mvp.v1.model;

import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;

import com.example.mvploginsystem.mvp.v1.RegisterContract;

public class RegisterModel implements RegisterContract.RegisterModel {
    @Override
    public void Register(String username, String password, RegisterCallback registerCallback) {
        new Handler().postDelayed(() ->{
                if(registerCallback==null){
                    throw new RuntimeException("loginDataCallback can not be null!!!");
                }
                registerCallback.getNameError(TextUtils.isEmpty(username));
                registerCallback.getPasswordError(TextUtils.isEmpty(password));
                if(!TextUtils.isEmpty(username)&&!TextUtils.isEmpty(password)){
                    registerCallback.getOnSuccess(true);
                }
                else {
                    registerCallback.getOnSuccess(false);
                }
            },200);

    }
}
