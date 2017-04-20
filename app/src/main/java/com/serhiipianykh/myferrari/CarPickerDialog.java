package com.serhiipianykh.myferrari;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;

/**
 * Created by serhiipianykh on 2017-04-20.
 */

public class CarPickerDialog extends DialogFragment {


    public static CarPickerDialog newInstance() {

        Bundle args = new Bundle();

        CarPickerDialog fragment = new CarPickerDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.fragment_car_picker_dialog, null);
        return new AlertDialog.Builder(getContext()).setView(v)
                .create();
    }
}
