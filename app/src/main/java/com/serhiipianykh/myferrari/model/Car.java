package com.serhiipianykh.myferrari.model;

/**
 * Created by serhiipianykh on 2017-04-19.
 */

public class Car {

    private String model;
    private String vin;
    private byte[] photo;
    private long purchaseDate;
    private CarStatus status;

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
}
