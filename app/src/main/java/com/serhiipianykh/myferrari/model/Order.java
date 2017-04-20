package com.serhiipianykh.myferrari.model;

/**
 * Created by serhiipianykh on 2017-04-19.
 */

public class Order {

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
}
