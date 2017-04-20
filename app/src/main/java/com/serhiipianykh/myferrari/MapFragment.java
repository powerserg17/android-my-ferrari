package com.serhiipianykh.myferrari;

import android.app.Activity;
import android.content.Intent;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.OnMapReadyCallback;
import com.serhiipianykh.myferrari.model.Order;

/**
 * Created by serhiipianykh on 2017-04-20.
 */

public class MapFragment extends Fragment {

    private MapView mapView;
    private MapboxMap mapboxMap;

    private Order order;

    private Button selectLocation;
    private ImageView dropPinView;

    public static MapFragment newInstance(Order passedOrder) {

        Bundle args = new Bundle();
        MapFragment fragment = new MapFragment();
        args.putParcelable("order",passedOrder);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        order = getArguments().getParcelable("order");
        Mapbox.getInstance(getContext(), "pk.eyJ1Ijoic2VyaGlpcGlhbnlraCIsImEiOiJjajFxZ3MxOXIwMDY5MndvNXFpNGVvd3Z5In0.1OLgfulreEZMlvkT-RU1vg");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_map, container, false);

        mapView = (MapView)v.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        dropPinView = new ImageView(getContext());
        dropPinView.setImageResource(R.drawable.map_marker);

        // Statically Set drop pin in center of screen
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
        float density = getResources().getDisplayMetrics().density;
        params.bottomMargin = (int) (12 * density);
        final float scale = getContext().getResources().getDisplayMetrics().density;
        int pixels = (int) (50 * scale + 0.5f);
        params.height = pixels;
        params.width = pixels;
        dropPinView.setLayoutParams(params);
        mapView.addView(dropPinView);

        mapView.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(MapboxMap map) {
                //Store for later
                mapboxMap = map;
            }
        });

        selectLocation = (Button)v.findViewById(R.id.select_location_btn);
        selectLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LatLng position = getMarkerLocation();
                order.setLatitude(position.getLatitude());
                order.setLongitude(position.getLongitude());
                OrderListFragment.orders.add(order);
                Intent intent = new Intent();
                intent.putExtra("order",order);
                getActivity().setResult(Activity.RESULT_OK, intent);
                getActivity().finish();
            }
        });

        return v;
    }

    private LatLng getMarkerLocation() {
        return mapboxMap.getProjection().fromScreenLocation(
                new PointF(dropPinView.getLeft() + (dropPinView.getWidth() / 2), dropPinView.getBottom())
        );
    }

    @Override
    public void onStart() {
        super.onStart();
        mapView.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
        mapView.onStop();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
}
