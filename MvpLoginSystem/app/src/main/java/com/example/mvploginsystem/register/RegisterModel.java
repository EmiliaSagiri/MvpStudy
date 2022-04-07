package com.example.mvploginsystem.register;

import android.os.Handler;
import android.text.TextUtils;

import com.example.mvploginsystem.login.loginModel;

public class RegisterModel  {
    interface OnRegisterFinishedListener {
        void onUsernameError();

        void onPasswordError();

        void onSuccess(String username,String password);
    }

    public void register(final String username, final String password, final RegisterModel.OnRegisterFinishedListener listener) {
        // Mock login. I'm creating a handler to delay the answer a couple of seconds
        new Handler().postDelayed(() -> {
            if (TextUtils.isEmpty(username)) {
                listener.onUsernameError();
                return;
            }
            if (TextUtils.isEmpty(password)) {
                listener.onPasswordError();
                return;
            }
            listener.onSuccess(username,password);
        }, 2000);
    }
}
