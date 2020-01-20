package com.qyhxxx.one.hp.presenter;

import com.qyhxxx.one.RequestCallback;
import com.qyhxxx.one.base.BasePresenter;
import com.qyhxxx.one.hp.bean.HpByMonthBean;
import com.qyhxxx.one.hp.contract.HpContract;
import com.qyhxxx.one.hp.model.HpModel;

import java.util.List;

public class HpListPresenter extends BasePresenter<HpContract.View, HpContract.Model> implements HpContract.Presenter {
    @Override
    protected HpContract.Model initModel() {
        return new HpModel();
    }

    @Override
    public void loadHpByMonth(String month) {
        mModel.getHpByMonth(month, new RequestCallback<List<HpByMonthBean.Hp>>() {
            @Override
            public void onSuccess(List<HpByMonthBean.Hp> data) {
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
