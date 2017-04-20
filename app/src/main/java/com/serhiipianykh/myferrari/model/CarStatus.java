package com.serhiipianykh.myferrari.model;

import android.app.Application;
import android.content.Context;

import com.serhiipianykh.myferrari.R;

/**
 * Created by serhiipianykh on 2017-04-19.
 */

public enum CarStatus {
    ready(R.string.status_ready),
    service(R.string.status_service),
    out(R.string.status_out);

    private int id;

    CarStatus(int id) {
        this.id = id;
    }

    public String toString(Context context) {
        return context.getString(id);
    }
}
