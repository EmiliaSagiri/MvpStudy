package com.example.mvploginsystem.register;

import com.example.mvploginsystem.login.LoginView;
import com.example.mvploginsystem.login.loginModel;

public class RegisterPresenter implements RegisterModel.OnRegisterFinishedListener {
    private RegisterModel model;
    private RegisterView registerView;
    public RegisterPresenter(RegisterModel model,RegisterView registerView){
        this.model = model ;
        this.registerView= registerView ;
    }

    public void validateCredentials(String username, String password) {

        model.register(username, password, this);
    }

    public void onDestroy(){
        registerView=null;
    }

    @Override
    public void onUsernameError() {
        if(registerView!=null){
            registerView.set_NameError();
        }
    }

    @Override
    public void onPasswordError() {
        if(registerView!=null){
            registerView.set_PasswordError();
        }

    }

    @Override
    public void onSuccess(String username,String password) {
        if(registerView!=null){
            registerView.set_OnSuccess(username,password);
        }
    }
}
