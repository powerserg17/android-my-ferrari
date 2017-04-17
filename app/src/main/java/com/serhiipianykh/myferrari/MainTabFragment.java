package com.serhiipianykh.myferrari;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhiipianykh on 2017-04-16.
 */

public class MainTabFragment extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private List<Fragment> mFragmentList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v =  inflater.inflate(R.layout.main_tab_layout,null);

        tabLayout = (TabLayout) v.findViewById(R.id.sliding_tabs);
        viewPager = (ViewPager) v.findViewById(R.id.main_viewpager);

        mFragmentList = new ArrayList<>();
        mFragmentList.add(new CarsListFragment());
        mFragmentList.add(new OrderListFragment());

        viewPager.setAdapter(new MainPagerAdapter(getActivity().getSupportFragmentManager(),getContext(),mFragmentList));

        tabLayout.setupWithViewPager(viewPager);
        return v;
    }
}
