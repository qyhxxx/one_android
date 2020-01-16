package com.qyhxxx.one.hp.contract;

import com.qyhxxx.one.base.BaseModel;
import com.qyhxxx.one.base.BaseView;
import com.qyhxxx.one.hp.bean.Hp;
import com.qyhxxx.one.hp.model.HpCallback;

import java.util.List;

public interface HpListContract {
    interface Model extends BaseModel {
        void getData(String month, HpCallback callback);
    }

    interface View extends BaseView {
        void setHpRecyclerView(List<Hp> data);
    }

    interface Presenter {
        void loadData(String month);
    }
}
