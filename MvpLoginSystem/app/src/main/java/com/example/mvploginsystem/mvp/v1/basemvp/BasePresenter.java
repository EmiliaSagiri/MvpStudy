package com.example.mvploginsystem.mvp.v1.basemvp;

public abstract class BasePresenter <V extends IBaseView> implements IBasePresenter {
    protected V mView;

    @Override
    public void attach(IBaseView view) {
        mView = (V) view;
    }

    @Override
    public void detach() {
        mView = null;
    }

}
