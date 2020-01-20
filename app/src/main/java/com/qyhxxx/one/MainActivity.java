package com.qyhxxx.one;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.qyhxxx.one.hp.view.HpListFragment;
import com.qyhxxx.one.reading.view.ReadingFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<Fragment> fragmentList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TabLayout tabLayout = findViewById(R.id.main_tab_layout);
        ViewPager viewPager = findViewById(R.id.main_view_pager);
        fragmentList = new ArrayList<Fragment>(){{
            add(new HpListFragment());
            add(new ReadingFragment());
        }};
        MainTapLayoutAdapter adapter = new MainTapLayoutAdapter(getSupportFragmentManager(), fragmentList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
