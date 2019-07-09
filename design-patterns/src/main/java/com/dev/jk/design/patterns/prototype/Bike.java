package com.dev.jk.design.patterns.prototype;

public class Bike implements Prototype, Vehicle {

    private String model;

    private Manufacturer manufacturer;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public Bike cretaePrototype() throws CloneNotSupportedException {
        return (Bike) clone();
    }
}
