package com.serhiipianykh.myferrari;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.serhiipianykh.myferrari.model.Car;
import com.serhiipianykh.myferrari.model.Order;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhiipianykh on 2017-04-16.
 */

public class OrderListFragment extends Fragment {

    public static List<Order> orders;

    private RecyclerView recyclerView;
    private FloatingActionButton addOrderBtn;

    private CarPickerDialog carPickerDialog;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orders = new ArrayList<>();
        for (Car car : CarsListFragment.cars) {
            orders.add(new Order(car, 50.3308, 6.942, 1491814800000l, 1491930000000l));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        recyclerView.getAdapter().notifyDataSetChanged();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_orders, container, false);

        recyclerView = (RecyclerView)v.findViewById(R.id.orders_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new OrderListAdapter(getContext(), orders));

        addOrderBtn = (FloatingActionButton)v.findViewById(R.id.add_order_fab);
        addOrderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                carPickerDialog = CarPickerDialog.newInstance(new ArrayList<>(CarsListFragment.cars));
                FragmentManager fm = getChildFragmentManager();
                carPickerDialog.show(fm,"TAG");
            }
        });

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode != Activity.RESULT_OK) {
            return;
        }
        if (requestCode == 100) {
            Order order = data.getExtras().getParcelable("order");
            orders.add(order);
            recyclerView.getAdapter().notifyDataSetChanged();
        }
    }
}
