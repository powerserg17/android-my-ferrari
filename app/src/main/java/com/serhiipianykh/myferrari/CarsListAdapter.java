package com.serhiipianykh.myferrari;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.serhiipianykh.myferrari.model.Car;

import java.util.List;

/**
 * Created by serhiipianykh on 2017-04-19.
 */

public class CarsListAdapter extends RecyclerView.Adapter<CarsListAdapter.ViewHolder> {

    private Context context;
    private List<Car> cars;

    public CarsListAdapter(Context context, List<Car> cars) {
        this.context = context;
        this.cars = cars;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView carModel;
        public TextView carStatus;
        public ImageView carPhoto;

        public ViewHolder(View view) {
            super(view);
            carModel = (TextView) view.findViewById(R.id.car_model);
            carStatus = (TextView) view.findViewById(R.id.car_status);
            carPhoto = (ImageView) view.findViewById(R.id.car_photo);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.car_adapter, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.carModel.setText(cars.get(position).getModel());
        holder.carStatus.setText(context.getString(R.string.status, cars.get(position).getStatus().toString(context)));
    }

    @Override
    public int getItemCount() {
        return cars.size();
    }
}
