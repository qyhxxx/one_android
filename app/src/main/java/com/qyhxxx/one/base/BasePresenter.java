package com.qyhxxx.one.base;

public abstract class BasePresenter<V extends BaseView, M extends BaseModel> {
    protected V mView;
    protected M mModel;

    public void onCreate(V view) {
        mView= view;
        mModel = initModel();
    }

    public void onDestroy() {
        mView = null;
        mModel = null;
    }

    protected boolean isViewAttached(){
        return mView != null;
    }

    protected abstract M initModel();
}
