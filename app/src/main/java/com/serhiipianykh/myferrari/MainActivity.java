package com.serhiipianykh.myferrari;

import android.support.v4.app.Fragment;

/**
 * Created by serhiipianykh on 2017-04-16.
 */

public class MainActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
        return MainFragment.newInstance();
    }
}
