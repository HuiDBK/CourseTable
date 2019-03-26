package com.example.mrliu.coursetable;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.mrliu.coursetable.adapter.TabFragPagerAdapter;
import com.example.mrliu.coursetable.fagment.SecondTabFragment;
import com.example.mrliu.coursetable.fagment.TableFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager table_pager;
    private List<Fragment> fragment_list;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        table_pager = (ViewPager) findViewById(R.id.table_pager);
        fragment_list = new ArrayList<>();
        fragment_list.add(new SecondTabFragment());
        fragment_list.add(new TableFragment());
        fragmentManager = getSupportFragmentManager();
        table_pager.setAdapter(new TabFragPagerAdapter(fragmentManager,fragment_list));
        table_pager.setCurrentItem(0);
    }
}
