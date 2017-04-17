package com.serhiipianykh.myferrari;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by serhiipianykh on 2017-04-16.
 */

public class MainPagerAdapter extends FragmentPagerAdapter {

    private String tabTitles[];
    Context mContext;
    private List<Fragment> mFragmentList;

    public MainPagerAdapter(FragmentManager fm, Context context, List<Fragment> listFragments) {
        super(fm);
        this.mFragmentList = listFragments;
        this.mContext = context;

        tabTitles = new String[] {context.getResources().getString(R.string.cars_tab_label),
                context.getResources().getString(R.string.orders_tab_label)};
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
