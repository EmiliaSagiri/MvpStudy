package com.example.mvploginsystem.login;

public class LoginPresenter implements loginModel.OnLoginFinishedListener{
    private loginModel model;
    private LoginView loginView;
    public LoginPresenter(loginModel model,LoginView loginView){
        this.model = model ;
        this.loginView = loginView;
    }

    public void validateCredentials(String username, String password) {

        model.login(username, password, this);
    }

    public void onDestroy(){
       loginView=null;
    }

    @Override
    public void onUsernameError() {
        if(loginView!=null){
            loginView.setNameError();
        }
    }

    @Override
    public void onPasswordError() {
        if(loginView!=null){
            loginView.setPasswordError();
        }

    }

    @Override
    public void onSuccess(String username,String password) {
        if(loginView!=null){
           loginView.setOnSuccess(username,password);
        }
    }
}
