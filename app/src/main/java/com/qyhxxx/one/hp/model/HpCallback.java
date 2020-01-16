package com.qyhxxx.one.hp.model;

public interface HpCallback<T> {
    void onSuccess(T data);

    void onFail(String msg);
}
