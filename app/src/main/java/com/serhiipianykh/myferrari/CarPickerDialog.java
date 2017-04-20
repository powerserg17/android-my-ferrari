package com.serhiipianykh.myferrari;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.serhiipianykh.myferrari.model.Car;
import com.serhiipianykh.myferrari.model.Order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by serhiipianykh on 2017-04-20.
 */

public class CarPickerDialog extends DialogFragment {

    private static final int DATE_ON = 10;
    private static final int TIME_ON = 20;
    private static final int DATE_OFF = 30;
    private static final int TIME_OFF = 40;

    private ArrayList<Car> cars;

    private Spinner carSelector;

    private Button location;

    private Button dateOn;
    private Button timeOn;
    private Button dateOff;
    private Button timeOff;

    private long dateStart = 0;
    private long dateFinish = 0;

    public static CarPickerDialog newInstance(ArrayList<Car> cars) {

        Bundle args = new Bundle();

        CarPickerDialog fragment = new CarPickerDialog();
        args.putParcelableArrayList("cars", cars);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        cars = getArguments().getParcelableArrayList("cars");

    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_car_picker_dialog, null);

        carSelector = (Spinner)v.findViewById(R.id.car_spinner);
        ArrayList<String> carsArray = new ArrayList<>();
        for (Car car : cars) {
            carsArray.add(car.getModel());
        }
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getContext(), R.layout.spinner_item,carsArray);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        carSelector.setAdapter(dataAdapter);

        location = (Button) v.findViewById(R.id.go_to_location_btn);
        location.setEnabled(false);
        location.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), OrderActivity.class);
                Order order = new Order(cars.get(carSelector.getSelectedItemPosition()), dateStart, dateFinish);
                intent.putExtra("order",order);
                startActivityForResult(intent, 100);
            }
        });

        dateOn = (Button) v.findViewById(R.id.date_on_btn);
        timeOn = (Button) v.findViewById(R.id.time_on_btn);
        dateOff = (Button) v.findViewById(R.id.date_off_btn);
        timeOff = (Button) v.findViewById(R.id.time_off_btn);

        timeOn.setEnabled(false);
        timeOff.setEnabled(false);

        dateOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                DatePickerFragment dialog = new DatePickerFragment();
                dialog.setTargetFragment(CarPickerDialog.this, DATE_ON);
                dialog.show(fm, "date_on");
            }
        });

        dateOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                DatePickerFragment dialog = new DatePickerFragment();
                dialog.setTargetFragment(CarPickerDialog.this, DATE_OFF);
                dialog.show(fm, "date_off");
            }
        });

        timeOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                TimePickerFragment dialog = new TimePickerFragment();
                dialog.setTargetFragment(CarPickerDialog.this, TIME_ON);
                dialog.show(fm, "time_on");
            }
        });

        timeOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                TimePickerFragment dialog = new TimePickerFragment();
                dialog.setTargetFragment(CarPickerDialog.this, TIME_OFF);
                dialog.show(fm, "time_off");
            }
        });


        return new AlertDialog.Builder(getContext()).setView(v)
                .create();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode != Activity.RESULT_OK) {
            return;
        }

        if (requestCode == DATE_ON) {
            Date date = (Date) data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            dateStart = date.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            dateOn.setText(sdf.format(date));
            timeOn.setEnabled(true);
        }

        if (requestCode == DATE_OFF) {
            Date date = (Date) data.getSerializableExtra(DatePickerFragment.EXTRA_DATE);
            dateFinish = date.getTime();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
            dateOff.setText(sdf.format(date));
            timeOff.setEnabled(true);
        }

        if (requestCode == TIME_ON) {
            int hour = data.getIntExtra(TimePickerFragment.EXTRA_HOUR, 0);
            int minute = data.getIntExtra(TimePickerFragment.EXTRA_MINUTE, 0);
            dateStart += hour * 60 * 60 * 1000;
            dateStart += minute * 60 * 1000;
            timeOn.setText(getString(R.string.time_formatter, hour, minute));
        }

        if (requestCode == TIME_OFF) {
            int hour = data.getIntExtra(TimePickerFragment.EXTRA_HOUR, 0);
            int minute = data.getIntExtra(TimePickerFragment.EXTRA_MINUTE, 0);
            dateFinish += hour * 60 * 60 * 1000;
            dateFinish += minute * 60 * 1000;
            timeOff.setText(getString(R.string.time_formatter, hour, minute));
        }

        canProceed();

    }

    private void canProceed() {
        if (dateStart>0 && dateFinish>0) {
            location.setEnabled(true);
        }
    }
}
