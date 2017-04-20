package com.serhiipianykh.myferrari;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.serhiipianykh.myferrari.model.Car;
import com.serhiipianykh.myferrari.model.Order;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

/**
 * Created by serhiipianykh on 2017-04-19.
 */

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.ViewHolder> {

    private Context context;
    private List<Order> orders;

    public OrderListAdapter(Context context, List<Order> orders) {
        this.context = context;
        this.orders = orders;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView carModel;
        public TextView orderLocation;
        public TextView orderDateOn;
        public TextView orderDateOff;

        public ViewHolder(View view) {
            super(view);
            carModel = (TextView) view.findViewById(R.id.order_car);
            orderLocation = (TextView) view.findViewById(R.id.order_location);
            orderDateOn = (TextView) view.findViewById(R.id.order_date_on);
            orderDateOff = (TextView) view.findViewById(R.id.order_date_off);
        }
    }

    @Override
    public OrderListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_adapter, parent, false);
        OrderListAdapter.ViewHolder vh = new OrderListAdapter.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(OrderListAdapter.ViewHolder holder, int position) {
        holder.carModel.setText(orders.get(position).getCar().getModel());
        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(context, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(orders.get(position).getLatitude(), orders.get(position).getLongitude(), 1);
            String city = addresses.get(0).getLocality();
            String country = addresses.get(0).getCountryName();
            holder.orderLocation.setText(context.getString(R.string.location, city, country));
            holder.orderDateOn.setText(context.getString(R.string.date_on, Long.toString(orders.get(position).getDateOn())));
            holder.orderDateOff.setText(context.getString(R.string.date_off, Long.toString(orders.get(position).getDateOff())));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getItemCount() {
        return orders.size();
    }

}
