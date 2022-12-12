package com.company;

public class Vehicle {
    private int vehicle_id;
    private String type;
    private String manufacturer;
    private String series;
    private String car_number;
    private String vin;
    private String owner_name;
    private String owner_surname;

    public Vehicle() {
    }

    public Vehicle(int vehicle_id, String type, String manufacturer, String series, String car_number, String vin, String owner_name, String owner_surname) {
        this.vehicle_id = vehicle_id;
        this.type = type;
        this.manufacturer = manufacturer;
        this.series = series;
        this.car_number = car_number;
        this.vin = vin;
        this.owner_name = owner_name;
        this.owner_surname = owner_surname;
    }

    public int getVehicle_id() {
        return vehicle_id;
    }

    public void setVehicle_id(int vehicle_id) {
        this.vehicle_id = vehicle_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getCar_number() {
        return car_number;
    }

    public void setCar_number(String car_number) {
        this.car_number = car_number;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public String getOwner_surname() {
        return owner_surname;
    }

    public void setOwner_surname(String owner_surname) {
        this.owner_surname = owner_surname;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "vehicle_id=" + vehicle_id +
                ", type='" + type + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", series='" + series + '\'' +
                ", car_number='" + car_number + '\'' +
                ", vin='" + vin + '\'' +
                ", owner_name='" + owner_name + '\'' +
                ", owner_surname='" + owner_surname + '\'' +
                '}';
    }
}

