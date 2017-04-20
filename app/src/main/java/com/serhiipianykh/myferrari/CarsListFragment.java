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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by serhiipianykh on 2017-04-16.
 */

public class CarsListFragment extends Fragment {

    public static List<Car> cars;

    private RecyclerView recyclerView;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cars = new ArrayList<>();
        cars.add(new Car("599XX", "1111", 1420070400000l));
        cars.add(new Car("FXX", "2222", 1420070400000l));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_cars, container, false);

        recyclerView = (RecyclerView)v.findViewById(R.id.cars_list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new CarsListAdapter(getContext(), cars));

        return v;
    }
}
