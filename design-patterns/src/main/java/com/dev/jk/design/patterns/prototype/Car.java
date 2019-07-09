package com.dev.jk.design.patterns.prototype;

import com.dev.jk.design.patterns.abstractfactory.domain.VegPizza;

public class Car implements Prototype, Vehicle {

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
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Car cretaePrototype() throws CloneNotSupportedException {
        return (Car) clone();
    }


}
