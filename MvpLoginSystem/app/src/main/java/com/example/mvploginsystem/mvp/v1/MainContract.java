package com.example.mvploginsystem.mvp.v1;

/**
 * 登录通用接口
 */
public interface MainContract {
    interface IMainModel {
        void login(String username, String password, LoginCallback loginCallback);
        interface LoginCallback{
            void getNameError(boolean isSuccess);
            void getPasswordError(boolean isSuccess);
            void getOnSuccess(boolean isSuccess);
        }
    }

    interface IMainView {
        void setNameError();

        void setPasswordError();

        void setOnSuccess(String username,String password);

        void onStartLogin();


    }

    interface IMainPresenter {
        void handlerData(String username,String password);
    }

}
