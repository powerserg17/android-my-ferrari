package com.serhiipianykh.myferrari;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
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

    private List<Order> orders;

    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        orders = new ArrayList<>();
        orders.add(new Order(new Car("599XX", "111", 1234), 50.3308, 6.942, 11, 22));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_orders, container, false);

        recyclerView = (RecyclerView)v.findViewById(R.id.orders_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new OrderListAdapter(getContext(), orders));

        return v;
    }

}
