package com.serhiipianykh.myferrari.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by serhiipianykh on 2017-04-19.
 */

public class Order implements Parcelable{

    private Car car;
    private double latitude;
    private double longitude;
    private long dateOn;
    private long dateOff;

    public Order(Car car, double latitude, double longitude, long dateOn, long dateOff) {
        this.car = car;
        this.latitude = latitude;
        this.longitude = longitude;
        this.dateOn = dateOn;
        this.dateOff = dateOff;
    }


    public Order(Car car, long dateOn, long dateOff) {
        this.car = car;
        this.dateOn = dateOn;
        this.dateOff = dateOff;
    }

    public Order(Parcel in) {
        this.dateOn = in.readLong();
        this.dateOff = in.readLong();
        this.car = in.readParcelable(Car.class.getClassLoader());
        this.latitude = in.readDouble();
        this.longitude = in.readDouble();
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public long getDateOn() {
        return dateOn;
    }

    public void setDateOn(long dateOn) {
        this.dateOn = dateOn;
    }

    public long getDateOff() {
        return dateOff;
    }

    public void setDateOff(long dateOff) {
        this.dateOff = dateOff;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeLong(dateOn);
        dest.writeLong(dateOff);
        dest.writeParcelable(car, 0);
        dest.writeDouble(latitude);
        dest.writeDouble(longitude);
    }

    public static final Parcelable.Creator<Order> CREATOR = new Parcelable.Creator<Order>(){
        public Order createFromParcel(Parcel in) {
            return new Order(in);
        }

        public Order[] newArray(int size) {
            return new Order[size];
        }
    };
}
