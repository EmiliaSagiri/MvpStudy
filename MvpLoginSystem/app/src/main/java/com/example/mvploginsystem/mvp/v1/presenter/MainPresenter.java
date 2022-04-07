package com.example.mvploginsystem.mvp.v1.presenter;

import com.example.mvploginsystem.DBManager;
import com.example.mvploginsystem.mvp.v1.MainContract;
import com.example.mvploginsystem.mvp.v1.model.MainModel;

public class MainPresenter implements MainContract.IMainPresenter {
    private MainContract.IMainModel mModel;
    private MainContract.IMainView mView;
    public MainPresenter(MainContract.IMainView view){
        this.mView = view;
        mModel = new MainModel();
    }
    @Override
    public void handlerData(String username,String password) {
        mModel.login(username,password,new MainContract.IMainModel.LoginCallback(){

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
