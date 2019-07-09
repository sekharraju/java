package com.dev.jk.design.patterns.prototype;

import java.util.HashMap;
import java.util.Map;

public class PrototypeFactoryImpl implements PrototypeFactory {

    private Map<Class<? extends Vehicle>, Vehicle> classObjectMap = new HashMap<>();

    public PrototypeFactoryImpl() {
        Manufacturer bmwManufacturer = new Manufacturer();
        bmwManufacturer.setName("BMW");
        Car prototypeCar = new Car();
        prototypeCar.setModel("X5");
        prototypeCar.setManufacturer(bmwManufacturer);
        Bike prorotypeBike = new Bike();
        prorotypeBike.setManufacturer(bmwManufacturer);
        prorotypeBike.setModel("X10");
        classObjectMap.put(Car.class, prototypeCar);
        classObjectMap.put(Bike.class, prorotypeBike);
    }

    public Map<Class<? extends Vehicle>, Vehicle> getClassObjectMap() {
        return classObjectMap;
    }


    @Override
    public <T extends Vehicle> T createPrototype(Class<T> tClasss) throws CloneNotSupportedException {

            Vehicle object = getClassObjectMap().get(tClasss);

            if (object != null) {
                return (T) object.cretaePrototype();
            }

            return null;
    }
}
