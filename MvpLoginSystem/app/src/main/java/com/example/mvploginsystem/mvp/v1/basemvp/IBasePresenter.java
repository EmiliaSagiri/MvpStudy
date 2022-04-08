package com.example.mvploginsystem.mvp.v1.basemvp;

public interface IBasePresenter<V extends IBaseView> {
    void attach(V view);
    void detach();
}
