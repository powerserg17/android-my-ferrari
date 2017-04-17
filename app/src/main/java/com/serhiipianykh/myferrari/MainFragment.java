package com.serhiipianykh.myferrari;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by serhiipianykh on 2017-04-16.
 */

public class MainFragment extends Fragment {

    private FragmentTransaction mFragmentTransaction;

    public static MainFragment newInstance() {

        Bundle args = new Bundle();

        MainFragment fragment = new MainFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_main, container, false);
        mFragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        mFragmentTransaction.replace(R.id.containerView, new MainTabFragment()).commit();
        return v;
    }
}
