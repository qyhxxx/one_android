package com.qyhxxx.one.hp.contract;

import com.qyhxxx.one.RequestCallback;
import com.qyhxxx.one.base.BaseModel;
import com.qyhxxx.one.base.BaseView;
import com.qyhxxx.one.hp.bean.HpByMonthBean;

import java.util.List;

public interface HpContract {
    interface Model extends BaseModel {
        void getHpByMonth(String month, RequestCallback callback);
    }

    interface View extends BaseView {
        void setHpRecyclerView(List<HpByMonthBean.Hp> data);
    }

    interface Presenter {
        void loadHpByMonth(String month);
    }
}
