package com.serhiipianykh.myferrari.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

/**
 * Created by serhiipianykh on 2017-04-19.
 */

public class Car implements Parcelable {

    private String model;
    private String vin;
    private byte[] photo;
    private long purchaseDate;
    private CarStatus status;

    public Car(Parcel in) {
        this.model = in.readString();
        this.vin = in.readString();
        this.photo = in.createByteArray();
        this.purchaseDate = in.readLong();
    }

    public Car(String model, String vin, long purchaseDate) {
        this.model = model;
        this.vin = vin;
        this.photo = null;
        this.purchaseDate = purchaseDate;
        this.status = CarStatus.ready;
    }

    public Car(String model, String vin, byte[] photo, long purchaseDate) {
        this.model = model;
        this.vin = vin;
        this.photo = photo;
        this.purchaseDate = purchaseDate;
        this.status = CarStatus.ready;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public long getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(long purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public CarStatus getStatus() {
        return status;
    }

    public void setStatus(CarStatus status) {
        this.status = status;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(model);
        dest.writeString(vin);
        dest.writeByteArray(photo);
        dest.writeLong(purchaseDate);
        dest.writeValue(status);
    }

    public static final Parcelable.Creator<Car> CREATOR = new Parcelable.Creator<Car>(){
        public Car createFromParcel(Parcel in) {
            return new Car(in);
        }

        public Car[] newArray(int size) {
            return new Car[size];
        }
    };
}
