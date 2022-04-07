package com.example.mvploginsystem.mvp.v1;

/**
 * 注册通用接口
 */
public interface RegisterContract {
    interface RegisterModel {
        void Register(String username, String password, RegisterCallback registerCallback);
        interface RegisterCallback{
            void getNameError(boolean isSuccess);
            void getPasswordError(boolean isSuccess);
            void getOnSuccess(boolean isSuccess);
        }
    }

    interface RegisterView {
        void setNameError();

        void setPasswordError();

        void setOnSuccess(String username,String password);

        void onStartRegister();


    }

    interface RegisterPresenter {
        void handlerData(String username,String password);
    }
}
