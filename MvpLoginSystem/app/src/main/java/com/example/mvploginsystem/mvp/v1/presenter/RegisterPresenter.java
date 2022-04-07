package com.example.mvploginsystem.mvp.v1.presenter;

import com.example.mvploginsystem.mvp.v1.MainContract;
import com.example.mvploginsystem.mvp.v1.RegisterContract;
import com.example.mvploginsystem.mvp.v1.model.MainModel;
import com.example.mvploginsystem.mvp.v1.model.RegisterModel;

public class RegisterPresenter implements RegisterContract.RegisterPresenter {
    private RegisterContract.RegisterModel mModel;
    private RegisterContract.RegisterView mView;
    public RegisterPresenter(RegisterContract.RegisterView view){
        this.mView = view;
        mModel = new RegisterModel();
    }
    @Override
    public void handlerData(String username,String password) {
        mModel.Register(username,password,new RegisterContract.RegisterModel.RegisterCallback(){

            @Override
            public void getNameError(boolean isSuccess) {
                if(isSuccess && mView!=null){
                    mView.setNameError();
                }
            }

            @Override
            public void getPasswordError(boolean isSuccess) {
                if(isSuccess && mView!=null){
                    mView.setPasswordError();
                }
            }

            @Override
            public void getOnSuccess(boolean isSuccess) {
                if(isSuccess && mView!=null){
                    mView.setOnSuccess(username,password);
                }
            }
        }  );

    }

    public void onDestroy(){
        mView=null;
    }
}
