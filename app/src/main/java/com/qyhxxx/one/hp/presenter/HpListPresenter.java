package com.qyhxxx.one.hp.presenter;

import com.qyhxxx.one.base.BasePresenter;
import com.qyhxxx.one.hp.bean.Hp;
import com.qyhxxx.one.hp.contract.HpListContract;
import com.qyhxxx.one.hp.model.HpCallback;
import com.qyhxxx.one.hp.model.HpModel;

import java.util.List;

public class HpListPresenter extends BasePresenter<HpListContract.View, HpListContract.Model> implements HpListContract.Presenter {
    @Override
    protected HpListContract.Model initModel() {
        return new HpModel();
    }

    @Override
    public void loadData(String month) {
        mModel.getData(month, new HpCallback<List<Hp>>() {
            @Override
            public void onSuccess(List<Hp> data) {
                if (isViewAttached()) {
                    mView.setHpRecyclerView(data);
                }
            }

            @Override
            public void onFail(String msg) {

            }
        });
    }
}
