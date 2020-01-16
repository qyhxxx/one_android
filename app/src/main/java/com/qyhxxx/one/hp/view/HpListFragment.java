package com.qyhxxx.one.hp.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.qyhxxx.one.R;
import com.qyhxxx.one.base.BaseFragment;
import com.qyhxxx.one.hp.bean.Hp;
import com.qyhxxx.one.hp.contract.HpListContract;
import com.qyhxxx.one.hp.presenter.HpListPresenter;
import com.qyhxxx.one.hp.presenter.HpRecyclerViewAdapter;

import java.util.List;

public class HpListFragment extends BaseFragment<HpListPresenter> implements HpListContract.View {
    private HpRecyclerViewAdapter adapter;

    @Override
    protected HpListPresenter initPresenter() {
        return new HpListPresenter();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hp_list_fragment, container, false);

        RecyclerView hpRecyclerView = view.findViewById(R.id.hp_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        hpRecyclerView.setLayoutManager(layoutManager);
        adapter = new HpRecyclerViewAdapter(getActivity());
        hpRecyclerView.setAdapter(adapter);
        mPresenter.loadData("2016-05");

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void setHpRecyclerView(final List<Hp> data) {
        adapter.addList(data);
    }
}
