package com.serhiipianykh.myferrari;

import android.support.v4.app.Fragment;

/**
 * Created by serhiipianykh on 2017-04-20.
 */

public class OrderActivity extends SingleFragmentActivity {
    @Override
    protected Fragment createFragment() {
        return MapFragment.newInstance();
    }
}
