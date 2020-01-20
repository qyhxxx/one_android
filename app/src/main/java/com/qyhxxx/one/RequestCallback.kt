package com.qyhxxx.one

interface RequestCallback<T> {
    fun onSuccess(data: T)

    fun onFail(msg: String)
}