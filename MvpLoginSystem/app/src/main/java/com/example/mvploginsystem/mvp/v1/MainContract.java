package com.example.mvploginsystem.mvp.v1;


import com.example.mvploginsystem.mvp.v1.basemvp.IBasePresenter;
import com.example.mvploginsystem.mvp.v1.basemvp.IBaseView;

/**
 * 登录通用接口
 */
public interface MainContract {
    interface IMainModel  {
        void login(String username, String password, LoginCallback loginCallback);
        interface LoginCallback{
            void getNameError(boolean isSuccess);
            void getPasswordError(boolean isSuccess);
            void getOnSuccess(boolean isSuccess);
        }
    }

    interface IMainView extends IBaseView {
        void setNameError();

        void setPasswordError();

        void setOnSuccess(String username,String password);

        void onStartLogin();


    }

    interface IMainPresenter extends IBasePresenter {
        void handlerData(String username,String password);
    }

}
