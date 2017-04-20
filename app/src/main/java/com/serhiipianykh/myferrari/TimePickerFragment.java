package com.serhiipianykh.myferrari;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TimePicker;

import java.util.Date;

/**
 * Created by serhiipianykh on 2017-04-20.
 */

public class TimePickerFragment extends DialogFragment {

    public static final String EXTRA_HOUR = "com.serhiipianykh.myferrari.hour";
    public static final String EXTRA_MINUTE = "com.serhiipianykh.myferrari.minute";


    private TimePicker timePicker;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.dialog_time, null);

        timePicker = (TimePicker) v.findViewById(R.id.dialog_time_time_picker);
        timePicker.setIs24HourView(true);
        timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {

            }
        });

        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                            sendResult(Activity.RESULT_OK, timePicker.getHour(), timePicker.getMinute());
                        } else {
                            sendResult(Activity.RESULT_OK, timePicker.getCurrentHour(), timePicker.getCurrentMinute());
                        }
                    }
                })
                .create();
    }



    private void sendResult(int resultCode, int hour, int minute) {
        if (getTargetFragment() == null) {
            return;
        }

        Intent intent = new Intent();
        intent.putExtra(EXTRA_HOUR, hour);
        intent.putExtra(EXTRA_MINUTE, minute);

        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }
}
