package com.serhiipianykh.myferrari;

import android.support.v4.app.Fragment;

import com.serhiipianykh.myferrari.model.Order;

/**
 * Created by serhiipianykh on 2017-04-20.
 */

public class OrderActivity extends SingleFragmentActivity {

    private Order order;

    @Override
    protected Fragment createFragment() {
        order = getIntent().getExtras().getParcelable("order");
        return MapFragment.newInstance(order);
    }
}
