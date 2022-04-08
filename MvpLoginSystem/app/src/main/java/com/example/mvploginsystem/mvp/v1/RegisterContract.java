package com.example.mvploginsystem.mvp.v1;

import com.example.mvploginsystem.mvp.v1.basemvp.IBasePresenter;
import com.example.mvploginsystem.mvp.v1.basemvp.IBaseView;

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

    interface RegisterView extends IBaseView {
        void setNameError();

        void setPasswordError();

        void setOnSuccess(String username,String password);

        void onStartRegister();


    }

    interface RegisterPresenter extends IBasePresenter {
        void handlerData(String username,String password);
    }
}
